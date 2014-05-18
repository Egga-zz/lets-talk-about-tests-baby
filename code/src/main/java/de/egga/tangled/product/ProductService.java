package de.egga.tangled.product;

import de.egga.tangled.shop.Shop;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

/**
 * @author egga
 */
public class ProductService {

    public List<Product> findProductsOfShop(final Shop shop) {
        return asList(
                new Product(randomUUID(), "first product"),
                new Product(randomUUID(), "second product")
        );
    }
}
