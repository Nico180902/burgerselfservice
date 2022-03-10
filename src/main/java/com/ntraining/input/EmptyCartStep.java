package com.ntraining.input;

public class EmptyCartStep implements ExecutionStep<EmptyCartInput> {

    private static final String PROMPT = """
            Your cart is empty.
            """
            + BurgerConstants.ADD_BURGER_PROMPT;

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
