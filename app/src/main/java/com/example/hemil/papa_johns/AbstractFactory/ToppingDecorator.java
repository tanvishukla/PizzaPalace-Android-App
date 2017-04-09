package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public abstract class ToppingDecorator implements Pizza {
        Pizza tempPizza;
    public ToppingDecorator(Pizza newPizza){
        tempPizza = newPizza;
    }

}
