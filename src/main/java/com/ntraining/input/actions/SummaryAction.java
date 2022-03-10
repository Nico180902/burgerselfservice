package com.ntraining.input.actions;

public class SummaryAction implements ActionValidator {

    public static final String ACTION_TOKEN = "Summary";

    @Override
    public boolean isValidAction(String input) {
        if (input == null) {
            return false;
        }

       return input.trim().equals(ACTION_TOKEN);
    }
}
