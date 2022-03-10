package com.ntraining.input;

public class FullCartStep implements ExecutionStep<FullCartInput> {

    private static final String PROMPT = """
            Your cart already consists of 3 burgers.
            """
            + BurgerConstants.CART_SUMMARY_PROMPT
            + BurgerConstants.REMOVE_BURGER_PROMPT
            + BurgerConstants.CHECKOUT_PROMPT;

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
