package com.ntraining.input;

public class FullCartStep implements ExecutionStep<FullCartInput> {

    private static final String PROMPT = "Your cart already consists of 3 burgers.\n" +
            "To remove a burger type the following:\n" +
            "-Burger,{id}\n\n" +
            "{id} ... the id of the burger\n\n" +
            "To complete your order type the following:\n" +
            "Checkout";

    @Override
    public String getPrompt() {
        return PROMPT;
    }

    @Override
    public ValidatedInput<FullCartInput> validate(String input) {
        return null;
    }

    @Override
    public void execute(FullCartInput executable) {

    }
}
