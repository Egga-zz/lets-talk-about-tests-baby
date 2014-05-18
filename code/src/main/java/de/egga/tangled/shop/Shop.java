package de.egga.tangled.shop;

import com.javadocmd.simplelatlng.LatLng;

import java.util.UUID;

/**
 * @author egga
 */
public class Shop {

    private UUID id;

    private String name;

    private LatLng location;

    public Shop() {
    }

    public Shop(final UUID id, final String name, final LatLng location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public UUID getId() {
        return id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(final LatLng location) {
        this.location = location;
    }
}
