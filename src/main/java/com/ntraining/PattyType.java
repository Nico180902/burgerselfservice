package com.ntraining;

public enum PattyType {
    MEAT(2),
    VEGGIE(2.5);

    private final double price;

    PattyType(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
