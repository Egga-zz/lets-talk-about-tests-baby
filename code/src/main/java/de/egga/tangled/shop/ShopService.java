package de.egga.tangled.shop;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.product.Product;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.UUID.randomUUID;

/**
 * @author egga
 */
public class ShopService {

    public List<Shop> findShopsByProduct(final Product product) {
        return asList(
                new Shop(randomUUID(), "some shop", new LatLng(1, 1)),
                new Shop(randomUUID(), "some shop", new LatLng(1, 4)),
                new Shop(randomUUID(), "some shop", new LatLng(4, 1)),
                new Shop(randomUUID(), "some shop", new LatLng(4, 4))
        );
    }

}
