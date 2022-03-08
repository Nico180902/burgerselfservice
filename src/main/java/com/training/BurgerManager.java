package com.training;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import java.util.*;

public class BurgerManager {

    BiMap<Integer, Burger> burgerList = HashBiMap.create();

    public void addBurger(int numberOfBurger, Burger burger) {
        burgerList.put(numberOfBurger, burger);
    }

    public void removeBurger(int numberOfBurger) {
        burgerList.remove(numberOfBurger);
    }

    public Burger getBurgerByNumber(int numberOfBurger) {
        return burgerList.get(numberOfBurger);
    }

    public Collection<Burger> getAllBurgers() {
      return burgerList.values();
        }

    public void addIngredient(int numberOfBurger, OptionalIngredients optionalIngredients) {

        if (OptionalIngredients.CHEESE.equals(optionalIngredients)) {
            getBurgerByNumber(numberOfBurger).setCheese(true);
            getBurgerByNumber(numberOfBurger).setPrice(getBurgerByNumber(numberOfBurger).getPrice() + 1.5);
        }

        if (OptionalIngredients.SALAD.equals(optionalIngredients)) {
            getBurgerByNumber(numberOfBurger).setSalad(true);
            getBurgerByNumber(numberOfBurger).setPrice(getBurgerByNumber(numberOfBurger).getPrice() + 1);
        }
        if (OptionalIngredients.TOMATOES.equals(optionalIngredients)) {
            getBurgerByNumber(numberOfBurger).setTomatoes(true);
            getBurgerByNumber(numberOfBurger).setPrice(getBurgerByNumber(numberOfBurger).getPrice() + 0.5);
        }
    }

    public double calculatePriceOfOrder() {

        if (burgerList.size() == 1) {
            return getBurgerByNumber(1).getPrice();

        } else if (burgerList.size() == 2) {
            return getBurgerByNumber(1).getPrice() + getBurgerByNumber(2).getPrice();

        } else if (burgerList.size() == 3) {
            return getBurgerByNumber(1).getPrice() + getBurgerByNumber(2).getPrice() +
                    getBurgerByNumber(3).getPrice();
        }
        return 0;
    }
}

