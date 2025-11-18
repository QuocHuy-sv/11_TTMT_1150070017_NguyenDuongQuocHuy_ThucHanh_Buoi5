package com.example.nguyenduongquochuylab;

public class Country {
    private String name;
    private String population;
    private int flagResId;

    public Country(String name, String population, int flagResId) {
        this.name = name;
        this.population = population;
        this.flagResId = flagResId;
    }

    public String getName() {
        return name;
    }

    public String getPopulation() {
        return population;
    }

    public int getFlagResId() {
        return flagResId;
    }
}
