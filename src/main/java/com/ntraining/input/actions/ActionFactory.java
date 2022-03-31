package com.ntraining.input.actions;

import com.ntraining.Cart;

public class ActionFactory {
    private final Cart cart;

    public ActionFactory(Cart cart) {
        this.cart = cart;
    }

    public Action createAddBurgerAction() {
        return new AddBurgerAction(cart);
    }

    public Action createRemoveBurgerAction() {
        return new RemoveBurgerAction(cart);
    }

    public Action createCheckoutAction() {
        return new CheckoutAction(cart);
    }

    public Action createSummaryAction() {
        return new SummaryAction(cart);
    }
}
