package de.egga.tangled.product;

import org.testng.annotations.Test;

import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * @author egga
 */
public class ProductServiceTest {

    @Test
    public void shouldReturnProduct() {
        ProductService productService = new ProductService();

        Product product = productService.findById(UUID.randomUUID());

        assertThat(product.getName(), is(equalTo("some product")));
    }
}
