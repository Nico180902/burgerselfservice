package com.ntraining.input.actions;

public class CheckoutAction implements ActionValidator {
    public static final String ACTION_TOKEN = "Checkout";

    @Override
    public boolean isValidAction(String input) {
        if (input == null) {
            return false;
        }

        return input.trim().equals(ACTION_TOKEN);
    }
}
