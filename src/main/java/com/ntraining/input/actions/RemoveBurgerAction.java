package com.ntraining.input.actions;

import com.ntraining.Cart;

public class RemoveBurgerAction implements Action {

    private final Cart cart;

    public RemoveBurgerAction(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean executeIfValid(String input) {
        Integer burgerId = validate(input);

        if (burgerId == null) {
            return false;
        }

        return execute(burgerId);
    }

    private Integer validate(String input) {
        if (input == null) {
            return null;
        }

        String[] actionParts = input.split(",");

        if (actionParts.length != 2) {
            return null;
        }

        if (!"-Burger".equals(actionParts[0])) {
            return null;
        }

        int burgerId;
        try {
            burgerId = Integer.parseInt(actionParts[1]);
        } catch (NumberFormatException e) {
            System.out.println(actionParts[1] + " is not a valid burger id.");
            return null;
        }

        return burgerId <= cart.getBurgers().size() ?
                burgerId : null;
    }

    private boolean execute(int burgerId) {
        return cart.removeBurgerByIndex(burgerId - 1);
    }
}
