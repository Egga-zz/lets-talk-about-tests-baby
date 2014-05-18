package de.egga.tangled.product;

import java.util.UUID;

import static java.util.UUID.randomUUID;

/**
 * @author egga
 */
public class ProductService {

    public Product findById(final UUID productId) {
        return new Product(randomUUID(), "some product");
    }
}
