package com.ntraining;

public class Cheese implements Ingredient {
    @Override
    public double getPrice() {
        return 1.5;
    }

    @Override
    public String toString() {
        return "Cheese{}";
    }
}
