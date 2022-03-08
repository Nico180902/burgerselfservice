package com.ntraining.input;

import javax.annotation.CheckForNull;

public interface ValidatedInput<T> {
    /**
     * This is a JavaDoc block
     * @return whether the input is valid
     */
    boolean isValid();

    /**
     * @return the input if it is valid, {@code false} otherwise
     */
    @CheckForNull
    T getInput();
}
