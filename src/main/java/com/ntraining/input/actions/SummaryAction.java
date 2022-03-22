package com.ntraining.input.actions;

import com.ntraining.Cart;

public class SummaryAction implements Action {

    public static final String ACTION_TOKEN = "Summary";

    private final Cart cart;

    public SummaryAction(Cart cart) {
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

        System.out.println(cart.getSummary());

        return true;
    }
}
