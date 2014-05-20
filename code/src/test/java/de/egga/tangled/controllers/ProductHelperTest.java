package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.product.Product;
import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * @author egga
 */
public class ProductHelperTest {

    private ProductHelper helper;

    private ProductService productService;

    private ShopService shopService;

    private final Product product = createProduct();

    private final LatLng hamburg = new LatLng(53.5653, 10.0014);

    private final LatLng paris = new LatLng(48.8567, 2.3508);

    private final Shop berlin = createShop("Berlin", 52.5167, 13.3833);

    private final Shop zagreb = createShop("Zagreb", 45.8167, 15.9833);

    @BeforeMethod
    public void setUp() {
        helper = new ProductHelper();

        productService = createMock(ProductService.class);
        helper.setProductService(productService);
        expect(productService.findById(product.getId())).andReturn(product);

        shopService = createMock(ShopService.class);
        helper.setShopService(shopService);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        verify(productService, shopService);
    }

    @Test
    public void shouldFindNearestShop() {
        setReturnedShops(asList(zagreb, berlin));

        List<Shop> shops = helper.getNearestShopsOfProduct(product.getId(), hamburg, 1000d);

        assertThat(shops, hasSize(2));
        assertThat(shops.get(0).getName(), is(equalTo("Berlin")));
        assertThat(shops.get(1).getName(), is(equalTo("Zagreb")));
    }

    @Test
    public void shouldHandleEmptyList() {
        setReturnedShops(new ArrayList<Shop>());

        List<Shop> shops = helper.getNearestShopsOfProduct(product.getId(), hamburg, 1000d);

        assertThat(shops, hasSize(0));
    }

    @Test
    public void shouldIgnoreFarShops() {
        setReturnedShops(asList(zagreb, berlin));

        List<Shop> shops = helper.getNearestShopsOfProduct(product.getId(), paris, 10d);

        assertThat(shops, hasSize(0));
    }

    private void setReturnedShops(final List<Shop> shopList) {
        expect(shopService.findShopsByProduct(product)).andReturn(shopList);
        replay(productService, shopService);
    }

    private Shop createShop(final String name, final double latitude, final double longitude) {
        Shop berlin = new Shop();
        berlin.setId(randomUUID());
        berlin.setName(name);
        berlin.setLocation(new LatLng(latitude, longitude));
        return berlin;
    }

    private Product createProduct() {
        Product product = new Product();
        product.setId(randomUUID());
        product.setName("some product");
        return product;
    }
}
