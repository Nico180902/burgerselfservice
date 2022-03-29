package com.ntraining;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private final List<Burger> burgers = new ArrayList<>();
    private boolean checkedOut = false;

    public List<Burger> getBurgers() {
        return burgers;
    }

    public void addBurger(Burger burger) {
        verifyNotCheckoutOut();
        if (burgers.size() < 3) {
            burgers.add(burger);
        }
    }

    public boolean removeBurgerByIndex(int index) {
        verifyNotCheckoutOut();
        Burger burger = burgers.remove(index);

        return burger != null;
    }

    /**
     * Must only be called when {@link this#getBurgers()} is not empty
     */
    public void checkout() {
        verifyNotCheckoutOut();

        if (this.burgers.isEmpty()) {
            throw new IllegalStateException("checkout was called even though cart is empty");
        }

        checkedOut = true;
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
            summary
                    .append(burgerId)
                    .append(": ")
                    .append(burger)
                    .append(" - ")
                    .append(burger.getPrice())
                    .append("\n");
            burgerId++;
        }

        return summary.append("Total: ")
                .append(getTotal())
                .append("\n")
                .toString();
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "burgers=" + burgers +
                ", isCheckedOut=" + checkedOut +
                '}';
    }

    private void verifyNotCheckoutOut() {
        if (checkedOut) {
            throw new UnsupportedOperationException("No cart modification possible after checking out.");
        }
    }
}
