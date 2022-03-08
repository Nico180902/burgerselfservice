package com.ntraining;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

import static java.util.Objects.requireNonNull;

public class Burger {
    private PattyType pattyType;
    private Ingredient cheese;
    private Ingredient salad;
    private Ingredient tomato;

    public Burger(@Nonnull PattyType pattyType, @CheckForNull Ingredient cheese, @CheckForNull Ingredient salad, @CheckForNull Ingredient tomato) {
        this.pattyType = requireNonNull(pattyType);
        this.cheese = cheese;
        this.salad = salad;
        this.tomato = tomato;
    }

    public double getPrice() {
        double price = 3;
        price += pattyType.getPrice();
        if (cheese != null) {
            price += cheese.getPrice();
        }
        if (salad != null) {
            price += salad.getPrice();
        }
        if (tomato != null) {
            price += tomato.getPrice();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "pattyType=" + pattyType +
                ", cheese=" + cheese +
                ", salad=" + salad +
                ", tomato=" + tomato +
                '}';
    }
}
