package com.example.model;

public class FruitStall {
    private String name;
    private double cherryPrice;
    private double peachPrice;
    private double pearPrice;
    private boolean hasCherry;
    private boolean hasPeach;
    private boolean hasPear;

    // Getters and setters
    public boolean hasPear() {
        return hasPear;
    }
    public boolean isHasPear() {
        return hasPear;
    }

    public double getCherryPrice() {
        return cherryPrice;
    }

    public double getPeachPrice() {
        return peachPrice;
    }

    public double getPearPrice() {
        return pearPrice;
    }

    public String getName() {
        return name;
    }

    // Getters and setters

    // Constructor
    public FruitStall(String name, double cherryPrice, double peachPrice, double pearPrice,
                      boolean hasCherry, boolean hasPeach, boolean hasPear) {
        this.name = name;
        this.cherryPrice = cherryPrice;
        this.peachPrice = peachPrice;
        this.pearPrice = pearPrice;
        this.hasCherry = hasCherry;
        this.hasPeach = hasPeach;
        this.hasPear = hasPear;
    }

    public boolean hasCherry() {
        return false;
    }

    public boolean hasPeach() {
        return false;
    }
}
