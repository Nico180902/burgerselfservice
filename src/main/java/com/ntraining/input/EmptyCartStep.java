package com.ntraining.input;

import com.google.common.collect.ImmutableSet;
import com.ntraining.Cart;
import com.ntraining.input.actions.Action;
import com.ntraining.input.actions.ActionFactory;
import com.ntraining.input.actions.AddBurgerAction;

import java.util.Collection;

public class EmptyCartStep implements ExecutionStep {

    private static final String PROMPT = """
            Your cart is empty.
            """
            + BurgerConstants.ADD_BURGER_PROMPT;

    private final Collection<Action> possibleActions;
    private final Cart cart;

    public EmptyCartStep(Cart cart, ActionFactory actionFactory) {
        this.cart = cart;
        possibleActions = ImmutableSet.of(
                actionFactory.createAddBurgerAction()
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

    // wahrheitstabelle
    // 0 1 | 0
    // 0 0 | 0
    // 1 1 | 1
    // 1 0 | 0

    // mit 3 variablen 8 möglichkeiten
    // 0 0 1 | 0
    // 0 0 0 | 0
    // 0 1 1 | 0
    // 0 1 0 | 0
    // 1 0 1 | 0
    // 1 0 0 | 0
    // 1 1 1 | 1
    // 1 1 0 | 0
}
