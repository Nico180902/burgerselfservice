package com.ntraining.input;

import com.google.common.collect.ImmutableSet;
import com.ntraining.Cart;
import com.ntraining.input.actions.*;

import java.util.Collection;

public class FullCartStep implements ExecutionStep {

    private static final String PROMPT = "Your cart already consists of " + BurgerConstants.CART_MAX_SIZE + " burgers.\n"
            + BurgerConstants.CART_SUMMARY_PROMPT
            + BurgerConstants.REMOVE_BURGER_PROMPT
            + BurgerConstants.CHECKOUT_PROMPT;

    private final Collection<Action> possibleActions;
    private final Cart cart;

    public FullCartStep(Cart cart) {
        this.cart = cart;
        possibleActions = ImmutableSet.of(
                new CheckoutAction(cart),
                new RemoveBurgerAction(cart),
                new SummaryAction(cart)
        );
    }

    @Override
    public String getPrompt() {
        return PROMPT;
    }

    @Override
    public Collection<Action> getPossibleActions() {
        return possibleActions;
    }

    @Override
    public boolean isResponsible() {
        return cart.getBurgers().size() == BurgerConstants.CART_MAX_SIZE;
    }
}
