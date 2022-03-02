package com.training;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean shouldLoopBeContinued = false;
        int numberOfBurger = 0;
        BurgerManager burgerManager = new BurgerManager();
        InputExecutor inputExecutor = new InputExecutor(burgerManager);

        System.out.println("Herzlich Willkommen beim Burger-Selbstbedienungsautomaten!");

        do {

            numberOfBurger = inputExecutor.askForTypeOfPattyAndInstantiateNewBurger(sc, numberOfBurger);

            inputExecutor.addOptionalIngredients(sc, numberOfBurger);

            inputExecutor.displayBurgersConfiguredSoFarWithPrice();

            numberOfBurger = inputExecutor.askIfABurgerShouldBeRemoved(sc, numberOfBurger, shouldLoopBeContinued);

            if (inputExecutor.isOrderFull(numberOfBurger)) {
                break;
            }

            shouldLoopBeContinued = inputExecutor.shouldAnotherBurgerBeConfigured(sc);

        } while (shouldLoopBeContinued);

        inputExecutor.terminateOrder();
    }

}
