package com.ntraining.input.actions;

import com.ntraining.Cart;

public class CheckoutAction implements Action {
    public static final String ACTION_TOKEN = "Checkout";

    private final Cart cart;

    public CheckoutAction(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean executeIfValid(String input) {
        if (input == null) {
            return false;
        }

        if (!input.trim().equals(ACTION_TOKEN)) {
            return false;
        }

        cart.checkout();

        return true;
    }
}
