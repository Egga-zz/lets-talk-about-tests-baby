package de.egga.tangled.shop;

import java.util.UUID;

/**
 * @author egga
 */
public class Shop {

    private UUID id;

    private String name;

    public Shop() {
    }

    public Shop(final UUID id, final String name) {
        this.id = id;
        this.name = name;
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
}
