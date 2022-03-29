package com.ntraining.input;

import com.ntraining.Cart;
import com.ntraining.input.actions.Action;
import com.ntraining.input.actions.AddBurgerAction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class EmptyCartStepTest {

    @Mock
    private Cart cartMock;

    private EmptyCartStep emptyCartStep;

    @BeforeEach
    void setUp() {
        emptyCartStep = new EmptyCartStep(cartMock);
    }

    @Test
    void getPossibleActions_includesOnlyAddBurgerAction() {
        Collection<Action> actions = emptyCartStep.getPossibleActions();

        assertThat(actions)
                .hasSize(1)
                .allMatch((action) -> action instanceof AddBurgerAction);
    }
}