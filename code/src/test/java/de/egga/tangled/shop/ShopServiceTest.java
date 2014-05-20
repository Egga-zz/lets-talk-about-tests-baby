package de.egga.tangled.shop;

import de.egga.tangled.product.Product;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

/**
 * @author egga
 */
public class ShopServiceTest {

    @Test
    public void shouldReturnShop() {
        ShopService shopService = new ShopService();

        List<Shop> shops = shopService.findShopsByProduct(new Product());

        assertThat(shops, hasSize(4));
        assertThat(shops.get(0).toString(), is(equalTo("Shop{name='Barcelona'}")));
    }
}
