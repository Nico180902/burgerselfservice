package com.ntraining.input;

import com.google.common.collect.ImmutableList;
import com.ntraining.Cart;
import com.ntraining.input.actions.ActionFactory;

import java.util.Collection;

public class InputExecutor {
    private final Collection<ExecutionStep> executionSteps;

    public InputExecutor(Cart cart, ActionFactory actionFactory) {
        executionSteps = ImmutableList.of(
                new EmptyCartStep(cart, actionFactory),
                new FilledCartStep(cart, actionFactory),
                new FullCartStep(cart, actionFactory),
                new CheckedOutStep(cart)
        );
    }

    public boolean shouldStop() {
        ExecutionStep executionStep = executionSteps.stream()
                .filter(ExecutionStep::isResponsible)
                .findFirst()
                .orElseThrow();

        return executionStep instanceof CheckedOutStep;
    }

    public String getPrompt() {
        ExecutionStep executionStep = executionSteps.stream()
                .filter(ExecutionStep::isResponsible)
                .findFirst()
                .orElseThrow();

        return executionStep.getPrompt();
    }

    public void handleInput(String input) {
        ExecutionStep executionStep = executionSteps.stream()
                .filter(ExecutionStep::isResponsible)
                .findFirst()
                .orElseThrow();

        executionStep.executeIfValid(input);
    }
}
