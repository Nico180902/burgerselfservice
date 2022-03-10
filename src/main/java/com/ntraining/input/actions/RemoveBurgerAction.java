package com.ntraining.input.actions;

public class RemoveBurgerAction implements ActionValidator {

    @Override
    public boolean isValidAction(String input) {
        if (input == null) {
           return false;
        }

        String[] actionParts = input.split(",");

        if (actionParts.length != 2) {
            return false;
        }

        if (!"-Burger".equals(actionParts[0])) {
            return false;
        }

        int burgerId;
        try {
            burgerId = Integer.parseInt(actionParts[1]);
        } catch (NumberFormatException e) {
            System.out.println(actionParts[1] + " is not a valid burger id.");
            return false;
        }

        return burgerId <= 3;
    }
}
