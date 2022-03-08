package com.ntraining;

import com.ntraining.input.BurgerBuildingException;

import java.util.ArrayList;
import java.util.Collection;

public class Cart {
    private Collection<Burger> burgers = new ArrayList<>();
    private boolean isCheckedOut = false;

    public Collection<Burger> getBurgers() {
        return burgers;
    }

    public void addBurger(Burger burger) {
        if (burgers.size() < 3) {
            burgers.add(burger);
        }
    }

    public boolean removeBurger(Burger burger) {
        return burgers.remove(burger);
    }

    /**
     * Must only be called when {@link this#getBurgers()} is not empty
     */
    // checked exceptions have to be either added to method signature or caught
//    public void checkout() throws BurgerBuildingException {
    public void checkout() throws BurgerBuildingException {
        if (this.burgers.isEmpty()) {
            // there are 2 types of exceptions, checked and unchecked.
            // unchecked exceptions do not have to be "checked"
//            throw new IllegalStateException("checkout was called even though cart is empty");
//            try {
////               throw new IllegalStateException("checkout was called even though cart is empty");
//                throw new BurgerBuildingException();
//
//            } catch (BurgerBuildingException e) {
//                System.out.println("");
//            }
              throw new BurgerBuildingException();
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
}
