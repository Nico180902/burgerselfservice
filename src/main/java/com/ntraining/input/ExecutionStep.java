package com.ntraining.input;

import com.ntraining.input.actions.Action;

import java.util.Collection;

public interface ExecutionStep {

    String getPrompt();

    Collection<Action> getPossibleActions();

    boolean isResponsible();

    default void executeIfValid(String input) {
        Collection<Action> actions = getPossibleActions();
        for (Action action : actions) {
            if (action.executeIfValid(input)) {
                return;
            }
        }
    }
}
