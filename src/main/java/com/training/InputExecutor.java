package com.training;

import java.util.Scanner;

public class InputExecutor {

    private final BurgerManager burgerManager;

    public InputExecutor(BurgerManager burgerManager) {
        this.burgerManager = burgerManager;
    }

    public int askForTypeOfPattyAndInstantiateNewBurger(Scanner sc, int numberOfBurger) {
        numberOfBurger++;
        boolean shouldLoopBeContinued;

        System.out.println("Konfiguration Ihres " + numberOfBurger + "-ten Burgers.");
        System.out.println("Bitte wählen Sie Ihr Burger Patty:");
        System.out.println("(f): Fleisch (2€)");
        System.out.println("(v): Vegetarisch (2,50€)");

        do {
            String userInput = sc.next().toLowerCase();
            TypeOfPatty decisionWhichTypeOfPatty = TypeOfPatty.fromInput(userInput);

            if (TypeOfPatty.MEAT.equals(decisionWhichTypeOfPatty)) {
                System.out.println("Sie haben das Patty aus Fleisch gewählt.");
                Burger burger = new Burger(numberOfBurger, decisionWhichTypeOfPatty);
                burgerManager.addBurger(numberOfBurger, burger);
                shouldLoopBeContinued = false;
            } else if (TypeOfPatty.VEGETARIAN.equals(decisionWhichTypeOfPatty)) {
                System.out.println("Sie haben das vegetarische Patty gewählt.");
                Burger burger = new Burger(numberOfBurger, decisionWhichTypeOfPatty);
                burgerManager.addBurger(numberOfBurger, burger);
                shouldLoopBeContinued = false;
            } else {
                System.out.println("Fehlerhafte Eingabe. Bitte wählen Sie zwischen Fleisch (f) und vegetarisch (v).");
                shouldLoopBeContinued = true;
            }
        } while (shouldLoopBeContinued);
        return numberOfBurger;
    }

    public void addOptionalIngredients(Scanner sc, int numberOfBurger) {

        System.out.println("Bitte wählen Sie aus folgenden Zutaten:");
        System.out.println("(k): Käse (+1,50€)");
        System.out.println("(s): Salat (+1€)");
        System.out.println("(t): Tomaten (+0,50€)");
        System.out.println("(x): Keine weiteren Zutaten, Burgerkonfiguration beenden");

        while (sc.hasNext()) {
            String userInput = sc.next().toLowerCase();
            OptionalIngredients optionalIngredient = OptionalIngredients.fromInput(userInput);

            if (optionalIngredient == null) {
                System.out.println("Fehlerhafte Eingabe. Bitte wählen Sie zwischen Käse (k), Salat (s), " +
                        "Tomaten (t) oder keinen weiteren Zutaten (x).");
                continue;
            }

            switch (optionalIngredient) {

                case CHEESE: {
                    if (burgerManager.getBurgerByNumber(numberOfBurger).hasCheese()) {
                        System.out.println("Fehler: Käse bereits hinzugefügt.");
                        continue;
                    }
                    System.out.println("Käse hinzugefügt.");
                    burgerManager.addIngredient(numberOfBurger, OptionalIngredients.CHEESE);
                    break;
                }
                case SALAD: {
                    if (burgerManager.getBurgerByNumber(numberOfBurger).hasSalad()) {
                        System.out.println("Fehler: Salat bereits hinzugefügt.");
                        continue;
                    }
                    System.out.println("Salat hinzugefügt.");
                    burgerManager.addIngredient(numberOfBurger, OptionalIngredients.SALAD);
                    break;

                }
                case TOMATOES: {
                    if (burgerManager.getBurgerByNumber(numberOfBurger).hasTomatoes()) {
                        System.out.println("Fehler: Tomaten bereits hinzugefügt.");
                        continue;
                    }
                    System.out.println("Tomaten hinzugefügt.");
                    burgerManager.addIngredient(numberOfBurger, OptionalIngredients.TOMATOES);
                    break;
                }
                case NOFURTHERINGREDIENTS: {
                    System.out.println("Burgerkonfiguration beendet.");
                    break;
                }
                default: {
                    System.out.println("Fehlerhafte Eingabe. Bitte wählen Sie zwischen Käse (k), Salat (s), " +
                            "Tomaten (t) oder keinen weiteren Zutaten (x).");
                    continue;
                }
            }
            if (OptionalIngredients.NOFURTHERINGREDIENTS.equals(optionalIngredient)) {
                break;
            }
        }
    }

    public void displayBurgersConfiguredSoFarWithPrice() {

        System.out.println("Bisher konfigurierte Burger:");
        burgerManager.getAllBurgers();
        System.out.println("Zwischensumme: " + burgerManager.calculatePriceOfOrder() + "€");
    }

    public int askIfABurgerShouldBeRemoved(Scanner sc, int numberOfBurger, boolean shouldLoopBeContinued) {

        do {
            System.out.println("Möchten Sie einen Burger aus dem Warenkorb entfernen? (j/n)");
            String userInput = sc.next().toLowerCase();
            UserDecision shouldABurgerBeRemoved = UserDecision.fromInput(userInput);

            if (UserDecision.YES.equals(shouldABurgerBeRemoved)) {
                System.out.println("Bitte geben Sie die Burgernummer jenes Burgers an, der entfernt werden soll:");
                int numberOfBurgerThatShouldBeRemoved = sc.nextInt();

                if (burgerManager.burgerList.containsKey(numberOfBurgerThatShouldBeRemoved)) {
                    burgerManager.removeBurger(numberOfBurgerThatShouldBeRemoved);
                    numberOfBurger--;
                    System.out.println("Der Burger wurde erfolgreich aus dem Warenkorb entfernt.");
                    if (burgerManager.burgerList.containsKey(numberOfBurgerThatShouldBeRemoved + 1)) {
                        burgerManager.getBurgerByNumber(numberOfBurgerThatShouldBeRemoved + 1)
                                .setNumberOfBurger(burgerManager.getBurgerByNumber
                                        (numberOfBurgerThatShouldBeRemoved + 1).getNumberOfBurger() - 1);

                        burgerManager.burgerList.forcePut(numberOfBurgerThatShouldBeRemoved,
                                burgerManager.getBurgerByNumber(numberOfBurgerThatShouldBeRemoved + 1));
                    }
                    if (burgerManager.burgerList.containsKey(numberOfBurgerThatShouldBeRemoved + 2)) {
                        burgerManager.getBurgerByNumber(numberOfBurgerThatShouldBeRemoved + 2)
                                .setNumberOfBurger(burgerManager.getBurgerByNumber
                                        (numberOfBurgerThatShouldBeRemoved + 2).getNumberOfBurger() - 1);

                        burgerManager.burgerList.forcePut(numberOfBurgerThatShouldBeRemoved + 1,
                                burgerManager.getBurgerByNumber(numberOfBurgerThatShouldBeRemoved + 2));
                    }
                    System.out.println("Ihr aktualisierter Warenkorb:");
                    burgerManager.getAllBurgers();
                    System.out.println("Zwischensumme: " + burgerManager.calculatePriceOfOrder() + "€");
                } else {
                    System.out.println("Fehler: Burger mit dieser Burgernummer konnte nicht gefunden werden.");
                    shouldLoopBeContinued = true;
                    continue;
                }
            } else if (UserDecision.NO.equals(shouldABurgerBeRemoved)) {
                shouldLoopBeContinued = false;

            } else {
                System.out.println("Falsche Eingabe. Bitte Wählen Sie zwischen Ja (j) und Nein (n)");
                shouldLoopBeContinued = true;
            }
            if (burgerManager.burgerList.size() == 0) {
                numberOfBurger = 0;
            }

        } while (shouldLoopBeContinued);
        return numberOfBurger;
    }

    public boolean isOrderFull(int numberOfBurger) {

        if (numberOfBurger == 3) {
            System.out.println("Maximale Anzahl an Burgern konfiguriert, schließe Bestellung ab...");
            return true;
        } else {
            return false;
        }
    }

    public boolean shouldAnotherBurgerBeConfigured(Scanner sc) {

        System.out.println("Möchten Sie noch einen weiteren Burger konfigurieren? (j/n)");

        while (sc.hasNext()) {
            String userInput = sc.next().toLowerCase();
            UserDecision shouldAnotherBurgerBeConfigured = UserDecision.fromInput(userInput);

            if (UserDecision.NO.equals(shouldAnotherBurgerBeConfigured)) {
                if (burgerManager.burgerList.size() == 0) {
                    System.out.println("Fehler: Sie können keine leere Bestellung erstellen. Bitte wählen Sie Ja (j).");
                } else {
                    return false;
                }
            } else if (UserDecision.YES.equals(shouldAnotherBurgerBeConfigured)) {
                return true;
            } else {
                System.out.println("Falsche Eingabe. Bitten wählen Sie zwischen Ja (j) und Nein (n)");
            }

        }
        return false;
    }

    public void terminateOrder() {
        System.out.println("Zusammenfassung Ihrer Bestellung:");
        burgerManager.getAllBurgers();
        System.out.println("Summe: " + burgerManager.calculatePriceOfOrder() + "€");
        System.out.println("Wir danken für Ihre Bestellung!");
    }
}
