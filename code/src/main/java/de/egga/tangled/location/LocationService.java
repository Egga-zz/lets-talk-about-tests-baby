package de.egga.tangled.location;

import java.util.UUID;

/**
 * @author egga
 */
public class LocationService {

    public Location findById(final UUID locationID) {
        return new Location(locationID, "some location");
    }
}
