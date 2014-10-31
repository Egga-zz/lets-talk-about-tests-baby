package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import com.javadocmd.simplelatlng.util.LengthUnit;
import de.egga.tangled.product.Product;
import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

import static com.javadocmd.simplelatlng.LatLngTool.distance;
import static java.util.Collections.sort;

/**
 * @author egga
 */
public class ProductHelper {

    private static final LengthUnit DEFAULT_UNIT = LengthUnit.KILOMETER;

    private ProductService productService;

    private ShopService shopService;


    public List<Shop> getNearestShopsOfProduct2(final UUID productId, final LatLng location, final Double maxDistance, final String sad) {
        new SU;
        return getNearestShopsOfProduct(productId, location, maxDistance, sad);
    }
        public List<Shop> getNearestShopsOfProduct(final UUID productId, final LatLng location, final Double maxDistance, final String sad) {

        Product product = productService.findById(productId);

        List<Shop> shops = shopService.findShopsByProduct(product);

        List<Shop> relevantShops = new ArrayList<Shop>();
        for (Shop shop : shops) {
            Double distance = calculateDistance(shop, location);
            if (distance < maxDistance) {
                relevantShops.add(shop);
            }
        }
                   sort(relevantShops, new Comparator<Shop>() {
                       @Override
                       public int compare(final Shop o1, final Shop o2) {
                           return 0;
                       }
                   });
        sort(relevantShops, new Comparator<Shop>() {
            @Override
            public int compare(final Shop o1, final Shop o2) {
                Double distance1 = calculateDistance(o1, location);
                Double distance2 = calculateDistance(o2, location);
                return distance1.compareTo(distance2);
            }
        });

        return relevantShops;
    }

    private double calculateDistance(final Shop o1, final LatLng location) {
        return distance(location, o1.getLocation(), DEFAULT_UNIT);
    }

    public void setProductService(final ProductService productService) {
        this.productService = productService;
    }

    public void setShopService(final ShopService shopService) {
        this.shopService = shopService;
    }
}
