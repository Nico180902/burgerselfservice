package com.ntraining.input;

public class FilledCartStep implements ExecutionStep<FilledCartInput> {

    private static final String PROMPT =
            BurgerConstants.CART_SUMMARY_PROMPT
            + BurgerConstants.ADD_BURGER_PROMPT
            + BurgerConstants.REMOVE_BURGER_PROMPT
            + BurgerConstants.CHECKOUT_PROMPT;

    @Override
    public String getPrompt() {
        return PROMPT;
    }

    @Override
    public ValidatedInput<FilledCartInput> validate(String input) {
        return null;
    }

    @Override
    public void execute(FilledCartInput executable) {

    }
}
