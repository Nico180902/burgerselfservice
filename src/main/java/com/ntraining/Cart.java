package com.ntraining;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Burger> burgers = new ArrayList<>();
    private boolean isCheckedOut = false;

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void addBurger(Burger burger) {
        if (burgers.size() < 3) {
            burgers.add(burger);
        }
    }

    public boolean removeBurgerByIndex(int index) {
        Burger burger = burgers.remove(index);

        return burger != null;
    }

    public boolean removeBurger(Burger burger) {
        return burgers.remove(burger);
    }

    /**
     * Must only be called when {@link this#getBurgers()} is not empty
     */
    public void checkout() {
        if (this.burgers.isEmpty()) {
            throw new IllegalStateException("checkout was called even though cart is empty");
        }

        isCheckedOut = true;
    }

    public double getTotal() {
        double total = 0;
        for (Burger burger : burgers) {
            total += burger.getPrice();
        }
        return total;
    }

    public String getSummary() {
        StringBuilder summary = new StringBuilder("Burgers in your cart: \n\n");
        int burgerId = 1;

        for (Burger burger : burgers) {
            summary.append(burgerId).append(": ").append(burger);
            burgerId++;
        }

        return summary.toString();
    }

    @Override
    public String toString() {
        return "Cart{" +
                "burgers=" + burgers +
                ", isCheckedOut=" + isCheckedOut +
                '}';
    }
}
