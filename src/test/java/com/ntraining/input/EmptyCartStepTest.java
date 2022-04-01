package com.ntraining.input;

import com.ntraining.Burger;
import com.ntraining.Cart;
import com.ntraining.input.actions.Action;
import com.ntraining.input.actions.ActionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmptyCartStepTest {

    @Mock
    private Cart cartMock;

    @Mock
    private ActionFactory actionFactoryMock;

    @Mock
    private Action addBurgerActionMock;

    private EmptyCartStep emptyCartStep;

    @BeforeEach
    void setUp() {
        when(actionFactoryMock.createAddBurgerAction()).thenReturn(addBurgerActionMock);

        emptyCartStep = new EmptyCartStep(cartMock, actionFactoryMock);
    }


    @Test
    void getPossibleActions_includesOnlyAddBurgerAction() {
        Collection<Action> actions = emptyCartStep.getPossibleActions();

        assertThat(actions)
                .hasSize(1)
                .containsExactly(addBurgerActionMock);
    }

//    @Test
//    void isResponsible_returnsTrueWhenCartIsNotCheckoutOutAndEmpty() {
//        when(cartMock.getBurgers()).thenReturn(Collections.emptyList());
//        when(cartMock.isCheckedOut()).thenReturn(false);
//
//        assertThat(emptyCartStep.isResponsible())
//                .isTrue();
//    }

    @ParameterizedTest
    @MethodSource("isResponsible_returnsExpectedResult_parameters")
    void isResponsible_returnsExpectedResult(List<Burger> burgers, boolean isCheckoutOut, boolean expectedResult) {
        when(cartMock.isCheckedOut()).thenReturn(isCheckoutOut);
        lenient().when(cartMock.getBurgers()).thenReturn(burgers);

        assertThat(emptyCartStep.isResponsible())
                .isEqualTo(expectedResult);
    }

    private static Stream<Arguments> isResponsible_returnsExpectedResult_parameters() {
        return Stream.of(
                Arguments.of(Collections.singletonList(mock(Burger.class)), false, false),
                Arguments.of(Collections.singletonList(mock(Burger.class)), true, false),
                Arguments.of(Collections.emptyList(), false, true),
                Arguments.of(Collections.emptyList(), true, false)
        );
    }
}