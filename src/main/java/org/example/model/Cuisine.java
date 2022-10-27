package org.example.model;

public enum Cuisine {
    POLISH("Polish"),
    MEXICAN("Mexican"),
    ITALIAN("Italian");
    private String value;

    Cuisine(String value) {
        this.value = value;
    }
}
