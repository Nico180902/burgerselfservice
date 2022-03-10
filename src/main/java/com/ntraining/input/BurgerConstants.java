package com.ntraining.input;

import com.ntraining.input.actions.CheckoutAction;
import com.ntraining.input.actions.SummaryAction;

public class BurgerConstants {
    public static final String ADD_BURGER_PROMPT = """
            To add a burger type the following:
            +Burger,Meat|Veggie[,Salad][,Cheese][,Tomato]

            | ... choose between two options
            [] ... optional
            """;

    public static final String REMOVE_BURGER_PROMPT = """
            To remove a burger type the following:
            -Burger,{id}

            {id} ... the id of the burger
            """;

    public static final String CHECKOUT_PROMPT = """
            To complete your order type the following:
            """
            + CheckoutAction.ACTION_TOKEN;

    public static final String CART_SUMMARY_PROMPT = """
            To view the summary of your cart type the following:
            """
            + SummaryAction.ACTION_TOKEN;

}
