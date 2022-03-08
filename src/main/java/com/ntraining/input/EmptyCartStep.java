package com.ntraining.input;

public class EmptyCartStep implements ExecutionStep<EmptyCartInput> {

    @Override
    public ValidatedInput<EmptyCartInput> validate(String input) {
        return null;
    }

    @Override
    public void execute(EmptyCartInput executable) {

    }
}
