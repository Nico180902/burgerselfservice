package com.training;

public enum TypeOfPatty {
    MEAT("f"),
    VEGETARIAN("v");

    private final String input;

    TypeOfPatty(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static TypeOfPatty fromInput(String input) {
        if (input == null) {
            return null;
        }
        for (TypeOfPatty pattyMeatOrVegetarian : TypeOfPatty.values()) {
            if (pattyMeatOrVegetarian.getInput().equals(input.toLowerCase())) {
                return pattyMeatOrVegetarian;
            }
        }
        return null;
    }
}
