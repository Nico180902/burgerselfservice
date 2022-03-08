package com.ntraining;


import com.ntraining.input.BurgerBuildingException;
import com.ntraining.input.InputExecutor;
import com.ntraining.input.ValidatedInput;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        try {
            cart.checkout();
        } catch (BurgerBuildingException e) {
            System.out.println("exception encountered");
        }
//        InputExecutor inputExecutor = new InputExecutor(cart);
//
//        while (scanner.hasNext()) {
//            String stringInput = scanner.nextLine();
//
//            if (inputExecutor.shouldStop()) {
//                break;
//            }
//
//            inputExecutor.executeIfValid(inputExecutor.validate(stringInput));
//        }
//
//        System.out.println(cart);
//        System.out.println("Total: " + cart.getTotal());
    }
}
