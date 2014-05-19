package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.product.Product;
import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @BeforeMethod
    public void setUp() {
        helper = new ProductHelper();

        productService = createMock(ProductService.class);
        helper.setProductService(productService);

        shopService = createMock(ShopService.class);
        helper.setShopService(shopService);
    }

    @Test
    public void shouldFindNearestShop() {
        LatLng hamburg = new LatLng(53.5653, 10.0014);

        Product product = new Product();
        product.setId(randomUUID());
        product.setName("some product");


        Shop berlin = new Shop();
        berlin.setId(randomUUID());
        berlin.setName("Zagreb");
        berlin.setLocation(new LatLng(52.5167, 13.3833));

        Shop zagreb = new Shop();
        zagreb.setId(randomUUID());
        zagreb.setName("Berlin");
        zagreb.setLocation(new LatLng(45.8167, 15.9833));

        expect(productService.findById(product.getId())).andReturn(product);

        expect(shopService.findShopsByProduct(product)).andReturn(asList(
                zagreb,
                berlin
        ));

        replay(productService, shopService);

        List<Shop> shops = helper.getNearestShopsOfProduct(product.getId(), hamburg);

        verify(productService, shopService);

        assertThat(shops, hasSize(2));
        assertThat(shops.get(0).getName(), is(equalTo("Berlin")));
    }
}
