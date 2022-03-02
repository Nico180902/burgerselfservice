package com.training;

public enum OptionalIngredients {
    CHEESE("k"),
    SALAD("s"),
    TOMATOES("t"),
    NOFURTHERINGREDIENTS("x");

    private final String input;

    OptionalIngredients(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static OptionalIngredients fromInput(String input) {
        if(input == null) {
            return null;
        }
        for(OptionalIngredients optionalIngredients : OptionalIngredients.values()) {
            if(optionalIngredients.getInput().equals(input.toLowerCase())) {
                return optionalIngredients;
            }
        }
        return null;
    }
}
