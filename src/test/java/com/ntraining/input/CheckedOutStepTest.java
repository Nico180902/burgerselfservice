package com.ntraining.input;

import com.ntraining.Cart;
import com.ntraining.input.actions.Action;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class CheckedOutStepTest {

    @Mock
    private Cart cartMock;

    private CheckedOutStep checkedOutStep;

    @BeforeEach
    void setUp() {
        checkedOutStep = new CheckedOutStep(cartMock);
    }

    @Test
    void getPossibleActions_returnsEmptyCollection() {
        Collection<Action> actions = checkedOutStep.getPossibleActions();

        assertThat(actions)
                .isEmpty();
    }

    @Test
    void isResponsible_returnsTrueIfCustomerIsCheckedOut() {
        when(cartMock.isCheckedOut()).thenReturn(true);

        assertThat(checkedOutStep.isResponsible()).isTrue();
    }

    @Test
    void isResponsible_returnsFalseIfCustomerIsNotCheckedOut() {
        when(cartMock.isCheckedOut()).thenReturn(false);

        assertThat(checkedOutStep.isResponsible()).isFalse();
    }
}