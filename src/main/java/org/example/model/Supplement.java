package org.example.model;

public enum Supplement {
    ICE_CUBES("ice cubes"),
    LEMON("lemon");
    private final String description;

    Supplement(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
