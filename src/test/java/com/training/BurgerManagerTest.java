package com.training;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class BurgerManagerTest {

    public static final int NUMBER_OF_BURGER = 1;
    private BurgerManager burgerManager;

    @BeforeEach
    void setUp() {
        burgerManager = new BurgerManager();

        int numberOfBurger = NUMBER_OF_BURGER;
        Burger burger = new Burger(numberOfBurger, TypeOfPatty.MEAT);
        burgerManager.addBurger(numberOfBurger, burger);
    }

    @Test
    void addBurger_addsBurgerToBiMapIfValidParametersArePassed() {
        int numberOfBurger = 2;
        Burger burger = new Burger(numberOfBurger, TypeOfPatty.MEAT);
        burgerManager.addBurger(numberOfBurger, burger);

        assertTrue(burgerManager.burgerList.containsValue(burger));
        assertTrue(burgerManager.burgerList.containsKey(numberOfBurger));
    }

    @Test
    void removeBurger_removesBurgerFromBiMapIfValidKeyIsPassed() {
        burgerManager.removeBurger(NUMBER_OF_BURGER);

        assertEquals(0, burgerManager.burgerList.size());
    }

    @Test
    void getBurgerByNumber_returnsBurgerObjectIfValidKeyIsPassed() {
        Burger burgerThatIsReturned = burgerManager.getBurgerByNumber(NUMBER_OF_BURGER);

        assertEquals(burgerManager.burgerList.get(NUMBER_OF_BURGER), burgerThatIsReturned);
    }

    @Test
    void getAllBurgers_returnsAllBurgerObjectsFromBiMap() {
        assertEquals(burgerManager.burgerList.values(), burgerManager.getAllBurgers());
    }

    @Test
    void addIngredient_setsBooleanOfAddedIngredientToTrueAndUpdatesPriceOfBurger() {

        burgerManager.addIngredient(NUMBER_OF_BURGER, OptionalIngredients.CHEESE);
        burgerManager.addIngredient(NUMBER_OF_BURGER, OptionalIngredients.SALAD);
        burgerManager.addIngredient(NUMBER_OF_BURGER, OptionalIngredients.TOMATOES);

        assertTrue(burgerManager.burgerList.get(NUMBER_OF_BURGER).hasCheese());
        assertTrue(burgerManager.burgerList.get(NUMBER_OF_BURGER).hasSalad());
        assertTrue(burgerManager.burgerList.get(NUMBER_OF_BURGER).hasTomatoes());

        assertEquals(8, burgerManager.burgerList.get(NUMBER_OF_BURGER).getPrice());
    }

    @Test
    void calculatePriceOfOrder_returnsTotalPriceOfAllBurgersInOrder() {
        assertEquals(burgerManager.burgerList.get(NUMBER_OF_BURGER).getPrice(), burgerManager.calculatePriceOfOrder());

        Burger burger = new Burger(2, TypeOfPatty.VEGETARIAN);
        burgerManager.addBurger(2, burger);
        assertEquals(burgerManager.burgerList.get(NUMBER_OF_BURGER).getPrice()
                + burgerManager.burgerList.get(2).getPrice(), burgerManager.calculatePriceOfOrder());

        Burger anotherBurger = new Burger(3, TypeOfPatty.MEAT);
        burgerManager.addBurger(3, anotherBurger);

        assertEquals(burgerManager.burgerList.get(NUMBER_OF_BURGER).getPrice()
                + burgerManager.burgerList.get(2).getPrice()
                + burgerManager.burgerList.get(3).getPrice(), burgerManager.calculatePriceOfOrder());
    }
}