package de.egga.tangled.controllers;

import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;
import org.testng.annotations.Test;

import java.util.List;

import static java.util.UUID.randomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

/**
 * @author egga
 */
public class ProductControllerTest {

    @Test
    public void shouldGetNearestBranches() {
        ProductHelper productHelper = new ProductHelper();
        productHelper.setShopService(new ShopService());
        productHelper.setProductService(new ProductService());

        ProductController productController = new ProductController();
        productController.setHelper(productHelper);

        List<Shop> shops = productController.getNearestShopsOfProduct(randomUUID(), 1d, 1d, null);
        assertThat(shops, hasSize(0));

        shops = productController.getNearestShopsOfProduct(randomUUID(), 1d, 1d, 10000d);
        assertThat(shops, hasSize(4));
    }
}
