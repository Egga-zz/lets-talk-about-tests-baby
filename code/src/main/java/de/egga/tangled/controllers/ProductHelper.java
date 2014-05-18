package de.egga.tangled.controllers;

import com.javadocmd.simplelatlng.LatLng;
import de.egga.tangled.location.LocationService;
import de.egga.tangled.product.Product;
import de.egga.tangled.product.ProductService;
import de.egga.tangled.shop.Shop;
import de.egga.tangled.shop.ShopService;

import java.util.List;
import java.util.UUID;

/**
 * @author egga
 */
public class ProductHelper {

    private LocationService locationService;

    private ProductService productService;

    private ShopService shopService;


    public List<Shop> getNearestShopsOfProduct(final UUID productId, final LatLng location) {

        Product product = productService.findById(productId);

        List<Shop> shops = shopService.findShopsByProduct(product);

        List<Shop> sortedShops = locationService.sortByDistance(location, shops);

        return sortedShops;
    }


    public void setLocationService(final LocationService locationService) {
        this.locationService = locationService;
    }

    public void setProductService(final ProductService productService) {
        this.productService = productService;
    }

    public void setShopService(final ShopService shopService) {
        this.shopService = shopService;
    }
}
