package com.training;

public enum UserDecision {
    YES("j"),
    NO("n");

    private final String input;

    UserDecision(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public static UserDecision fromInput(String input) {
        if (input == null) {
            return null;
        }
        for (UserDecision userDecision : UserDecision.values()) {
            if (userDecision.getInput().equals(input.toLowerCase())) {
                return userDecision;
            }
        }
        return null;
    }
}
