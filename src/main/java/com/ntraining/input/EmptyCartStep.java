package com.ntraining.input;

import com.google.common.collect.ImmutableSet;
import com.ntraining.Cart;
import com.ntraining.input.actions.Action;
import com.ntraining.input.actions.AddBurgerAction;
import com.ntraining.input.actions.RemoveBurgerAction;

import java.util.Collection;

public class EmptyCartStep implements ExecutionStep {

    private static final String PROMPT = """
            Your cart is empty.
            """
            + BurgerConstants.ADD_BURGER_PROMPT;

    private final Collection<Action> possibleActions;
    private final Cart cart;

    public EmptyCartStep(Cart cart) {
        this.cart = cart;
        possibleActions = ImmutableSet.of(
                new AddBurgerAction(cart)
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
        return !cart.isCheckedOut() && cart.getBurgers().isEmpty();
    }
}
