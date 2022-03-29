package com.ntraining;


import com.ntraining.input.InputExecutor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        InputExecutor inputExecutor = new InputExecutor(cart);

        System.out.println(inputExecutor.getPrompt());

        while (scanner.hasNext()) {
            String stringInput = scanner.nextLine();

            inputExecutor.handleInput(stringInput);

            System.out.println(inputExecutor.getPrompt());

            if (inputExecutor.shouldStop()) {
                break;
            }
        }
    }
}
