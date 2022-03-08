package com.training;


public class Burger {

    int numberOfBurger;
    private String patty;
    private boolean cheese;
    private boolean salad;
    private boolean tomato;
    private double price = 3;

    public Burger(int numberOfBurger, TypeOfPatty typeOfPatty) {
        if (TypeOfPatty.MEAT.equals(typeOfPatty)) {
            patty = "Fleisch";
            price += 2;
        }
        if (TypeOfPatty.VEGETARIAN.equals(typeOfPatty)) {
            patty = "Vegetarisch";
            price += 2.5;
        }
        this.numberOfBurger = numberOfBurger;
    }

    @Override
    public String toString() {
        return "Burger: " +
                "Burgernummer: " + numberOfBurger +
                ", Patty: " + patty +
                ", Käse: " + cheese +
                ", Salat: " + salad +
                ", Tomaten: " + tomato +
                ", Preis: " + price + "€";
    }

    public int getNumberOfBurger() {
        return numberOfBurger;
    }

    public void setNumberOfBurger(int numberOfBurger) {
        this.numberOfBurger = numberOfBurger;
    }

    public boolean hasCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean hasSalad() {
        return salad;
    }

    public void setSalad(boolean salad) {
        this.salad = salad;
    }

    public boolean hasTomatoes() {
        return tomato;
    }

    public void setTomatoes(boolean tomato) {
        this.tomato = tomato;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
