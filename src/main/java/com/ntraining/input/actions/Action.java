package com.ntraining.input.actions;

public interface Action {
    /**
     * Executes the input if it matches the {@link Action} and is valid.
     *
     * @param input the input string specifying the action
     * @return whether the input was executed
     */
    boolean executeIfValid(String input);
}
