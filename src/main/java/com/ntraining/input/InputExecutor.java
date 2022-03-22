package com.ntraining.input;

import com.google.common.collect.ImmutableList;
import com.ntraining.Cart;

import java.util.Collection;

public class InputExecutor {
    private final Collection<ExecutionStep> executionSteps;

    public InputExecutor(Cart cart) {
        executionSteps = ImmutableList.of(
                new EmptyCartStep(cart),
                new FilledCartStep(cart),
                new FullCartStep(cart)
        );
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
