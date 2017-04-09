package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public class Garlic extends ToppingDecorator {

    public Garlic(Pizza newPizza){
        super(newPizza);
    }

    public String getName(){

        return tempPizza.getName() + ",Garlic";


    }

    public double getCost()
    {

        return tempPizza.getCost() + 2;

    }
}
