package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 12/5/2015.
 */
public class Brownie implements Desserts {
    @Override
    public String getName() {
        return "Domino`s Marbled Cookie Brownie";
    }

    @Override
    public double getCost(int quantity) {
        return quantity*5.49;
    }
}
