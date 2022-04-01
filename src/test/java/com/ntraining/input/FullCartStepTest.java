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
class FullCartStepTest {

    @Mock
    private Cart cartMock;

    @Mock
    private ActionFactory actionFactoryMock;

    @Mock
    private Action removeBurgerActionMock;

    @Mock
    private Action checkoutActionMock;

    @Mock
    private Action summaryActionMock;

    private FullCartStep fullCartStep;

    @BeforeEach
    void setUp() {

        when(actionFactoryMock.createRemoveBurgerAction()).thenReturn(removeBurgerActionMock);
        when(actionFactoryMock.createSummaryAction()).thenReturn(summaryActionMock);
        when(actionFactoryMock.createCheckoutAction()).thenReturn(checkoutActionMock);

        fullCartStep = new FullCartStep(cartMock, actionFactoryMock);

    }

    @Test
    void getPossibleActions_includesCorrespondingActions() {
        Collection<Action> actions = fullCartStep.getPossibleActions();

        assertThat(actions)
                .hasSize(3)
                .containsExactly(removeBurgerActionMock, summaryActionMock, checkoutActionMock);
    }

    @ParameterizedTest
    @MethodSource("isResponsible_returnsExpectedResult_parameters")
    void isResponsible_returnsExpectedResult(List<Burger> burgers, boolean isCheckedOut, boolean expectedResult) {
        when(cartMock.isCheckedOut()).thenReturn(isCheckedOut);
        lenient().when(cartMock.getBurgers()).thenReturn(burgers);

        assertThat(fullCartStep.isResponsible()).isEqualTo(expectedResult);
    }

    private static Stream<Object> isResponsible_returnsExpectedResult_parameters() {
        return Stream.of(
                Arguments.of(List.of(mock(Burger.class), mock(Burger.class), mock(Burger.class)), false, true),
                Arguments.of(List.of(mock(Burger.class), mock(Burger.class), mock(Burger.class)), true, false),
                Arguments.of(Collections.emptyList(), true, false),
                Arguments.of(Collections.emptyList(), false, false)


        );
    }
}