package com.ntraining.input;

// steps in exercise
// empty cart -> can only add
// filled, not full cart -> can view, can remove, can add, can checkout
// full cart -> can remove, can checkout

// <> braces => generics
public interface ExecutionStep<T> {

    String getPrompt();

    ValidatedInput<T> validate(String stringInput);

    void execute(T input);
}
