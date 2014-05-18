package de.egga.tangled.shop;

import java.util.UUID;

/**
 * @author egga
 */
public class ShopService {

    public Shop findById(final UUID shopId) {
        return new Shop(shopId, "some shop");
    }
}
