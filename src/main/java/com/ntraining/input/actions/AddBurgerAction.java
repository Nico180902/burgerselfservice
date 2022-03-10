package com.ntraining.input.actions;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class AddBurgerAction implements ActionValidator {
//    +Burger,Meat|Veggie[,Salad][,Cheese][,Tomato]
    private static final Set<String> INGREDIENT_STRINGS = ImmutableSet.of("Salad", "Cheese", "Tomato");

    @Override
    public boolean isValidAction(String input) {
        if (input == null) {
            return false;
        }

        String[] actionParts = input.split(",");

        if (actionParts.length >= 2 && actionParts.length <= 5) {
            return false;
        }

        if (!"+Burger".equals(actionParts[0])) {
            return false;
        }

        if (!actionParts[1].equals("Meat") && !actionParts[1].equals("Veggie")) {
//        if (!(actionParts[1].equals("Meat") || actionParts[1].equals("Veggie"))) {
            System.out.println(actionParts[1] + " is not a valid patty type.");
            return false;
        }

        List<String> actionList = Arrays.asList(actionParts);
        actionList.remove(0);
        actionList.remove(1);

        if (!INGREDIENT_STRINGS.containsAll(actionList)) {
            return false;
        }

        return Sets.newHashSet(actionList).size() >= actionList.size();
    }
}
