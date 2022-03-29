package com.ntraining.input;

import com.ntraining.Cart;
import com.ntraining.input.actions.Action;

import java.util.Collection;
import java.util.Collections;

public class CheckedOutStep implements ExecutionStep {
    private final Cart cart;

    public CheckedOutStep(Cart cart) {
        this.cart = cart;
    }

    @Override
    public String getPrompt() {
        return "Thank you for doing business with us.";
    }

    @Override
    public Collection<Action> getPossibleActions() {
        return Collections.emptySet();
    }

    @Override
    public boolean isResponsible() {
        return cart.isCheckedOut();
    }
}
