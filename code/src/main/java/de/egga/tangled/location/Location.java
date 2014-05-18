package de.egga.tangled.location;

import java.util.UUID;

/**
 * @author egga
 */
public class Location {

    private UUID id;

    private String name;

    public Location() {
    }

    public Location(final UUID id, final String name) {
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
