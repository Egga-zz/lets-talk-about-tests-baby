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
                new Shop(randomUUID(), "Barcelona", new LatLng(41.3833, 2.1833)),
                new Shop(randomUUID(), "Berlin", new LatLng(52.5167, 13.3833)),
                new Shop(randomUUID(), "Zagreb", new LatLng(45.8167, 15.9833)),
                new Shop(randomUUID(), "Krakow", new LatLng(50.0614, 19.9372))
        );
    }

}
