package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.location.LocationService;
import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author egga
 */
public class ProductHelperTest {

    private ProductHelper helper;

    @BeforeMethod
    public void setUp() {
        helper = new ProductHelper();
        helper.setLocationService(new LocationService());
        helper.setProductService(new ProductService());
        helper.setShopService(new ShopService());
    }

    @Test
    public void shouldNotCrash() {
        UUID productId = UUID.fromString("1483a5c4-13ed-4c44-a466-6ba929a6e8ba");
        LatLng location = new LatLng(2, 2);

        List<Shop> shops = helper.getNearestShopsOfProduct(productId, location);

        assertThat(shops, hasSize(4));
    }
}
