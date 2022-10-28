package org.example.model;

public enum Cuisine {
    POLISH("Polish"),
    MEXICAN("Mexican"),
    ITALIAN("Italian");
    private final String description;

    Cuisine(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
