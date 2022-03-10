package com.ntraining.input;

public class EmptyCartStep implements ExecutionStep<EmptyCartInput> {

    private static final String PROMPT = "Your cart is empty.\n" +
            "To add a burger type the following\n" +
            "+Burger,Meat|Veggie[,Salad][,Cheese][,Tomato]\n\n" +
            "| ... choose between two options\n" +
            "[] ... optional";

    @Override
    public String getPrompt() {
        return PROMPT;
    }

    @Override
    public ValidatedInput<EmptyCartInput> validate(String input) {
        return null;
    }

    @Override
    public void execute(EmptyCartInput executable) {

    }
}
