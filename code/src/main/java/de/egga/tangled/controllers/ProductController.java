package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.shop.Shop;

import java.util.List;
import java.util.UUID;

/**
 * @author egga
 */
public class ProductController {

    private final static Double DEFAULT_MAX_DISTANCE = 500d;


    private ProductHelper helper;

    public List<Shop> getNearestBranchesOfProduct(
            UUID productId,
            Double latitude,
            Double longitude,
            Double maxDistance
    ) {
        LatLng location = new LatLng(latitude, longitude);
        if (maxDistance == null) {
            maxDistance = DEFAULT_MAX_DISTANCE;
        }
        return helper.getNearestShopsOfProduct(productId, location, maxDistance);
    }
}
