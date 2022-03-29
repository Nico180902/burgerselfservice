package com.ntraining.input.actions;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.ntraining.*;

import java.util.*;
import java.util.stream.Collectors;

public class AddBurgerAction implements Action {
    private static final Map<String, Ingredient> INGREDIENTS_BY_STRING = ImmutableMap.of(
            "Salad", new Salad(),
            "Cheese", new Cheese(),
            "Tomato", new Tomato()
    );

    private final Cart cart;

    public AddBurgerAction(Cart cart) {
        this.cart = cart;
    }

    @Override
    public boolean executeIfValid(String input) {
        Burger burger = validate(input);

        if (burger == null) {
            return false;
        }

        execute(burger);

        return true;
    }

    private Burger validate(String input) {
        if (input == null) {
            return null;
        }

        String[] actionParts = input.split(",");

        if (actionParts.length < 2 || actionParts.length > 5) {
            return null;
        }

        if (!"+Burger".equals(actionParts[0])) {
            return null;
        }

        String pattyTypeString = actionParts[1];
        if (!pattyTypeString.equals("Meat") && !pattyTypeString.equals("Veggie")) {
            System.out.println(pattyTypeString + " is not a valid patty type.");
            return null;
        }
        PattyType pattyType = pattyTypeForString(pattyTypeString);

        List<String> actionList = new ArrayList<>(Arrays.asList(actionParts));
        actionList.remove(0);
        actionList.remove(0);

        if (!INGREDIENTS_BY_STRING.keySet().containsAll(actionList)) {
            System.out.println("Invalid ingredient encountered");
            return null;
        }


        Set<String> actionSet = Sets.newHashSet(actionList);
        if (actionSet.size() != actionList.size()) {
            System.out.println("Every ingredient can only be added once.");
            return null;
        }
        Set<Ingredient> ingredients = getIngredientsFromStrings(actionSet);

        Ingredient cheese = ingredients.stream()
                .filter(ingredient -> ingredient instanceof Cheese)
                .findFirst()
                .orElse(null);
        Ingredient salad = ingredients.stream()
                .filter(ingredient -> ingredient instanceof Salad)
                .findFirst()
                .orElse(null);
        Ingredient tomato = ingredients.stream()
                .filter(ingredient -> ingredient instanceof Tomato)
                .findFirst()
                .orElse(null);

        return new Burger(pattyType, cheese, salad, tomato);
    }

    private void execute(Burger burger) {
        cart.addBurger(burger);
    }

    private Set<Ingredient> getIngredientsFromStrings(Collection<String> ingredientStrings) {
        return ingredientStrings.stream()
                .map(INGREDIENTS_BY_STRING::get)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    private PattyType pattyTypeForString(String pattyType) {
        return Arrays.stream(PattyType.values())
                .filter(pattyTypeValue -> pattyTypeValue.name().equalsIgnoreCase(pattyType))
                .findFirst()
                .orElseThrow();
    }
}
