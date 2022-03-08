package com.ntraining.input;

import com.ntraining.Cart;

public class InputExecutor {

    private ExecutionStep<?> currentStep = new EmptyCartStep();
    private final Cart cart;
    private boolean shouldStop;

    public InputExecutor(Cart cart) {
        this.cart = cart;
    }

    public ValidatedInput<?> validate(String stringInput) {
        return currentStep.validate(stringInput);
    }

    public boolean shouldStop() {
        return shouldStop;
    }

    public void executeIfValid(ValidatedInput<?> validatedInput) {
        if (validatedInput.isValid()) {
           return;
        }

        // casting an unknown type, not very safe. should only be used when we know what we are doing
//        String emptyCartInput = (String) validatedInput.getInput();
    }
}
