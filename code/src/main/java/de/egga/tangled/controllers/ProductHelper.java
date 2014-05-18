package de.egga.tangled.controllers;

import de.egga.tangled.location.Location;
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


    public List<Product> getProductsInCity(final UUID shopId, final UUID locationID) {
        Shop shop = shopService.findById(shopId);
        Location location = locationService.findById(locationID);

        List<Product> products = productService.findProductsOfShop(shop);

        return products;
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
