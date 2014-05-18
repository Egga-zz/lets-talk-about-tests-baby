package de.egga.tangled.controllers;

import de.egga.tangled.product.Product;

import java.util.List;
import java.util.UUID;

/**
 * @author egga
 */
public class ProductController {

    private ProductHelper helper;

    public List<Product> getProductsInCity(UUID shopId, UUID locationID) {
        return helper.getProductsInCity(shopId, locationID);
    }
}
