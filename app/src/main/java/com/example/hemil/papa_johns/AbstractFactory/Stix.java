package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 12/5/2015.
 */
public class Stix implements Desserts {
    @Override
    public String getName() {
        return "Cinna Stix";
    }

    @Override
    public double getCost(int quantity) {
        return quantity*4.49;
    }
}
