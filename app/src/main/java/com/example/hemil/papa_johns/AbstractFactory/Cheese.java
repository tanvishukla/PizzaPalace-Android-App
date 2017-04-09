package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public class Cheese extends ToppingDecorator {

    public Cheese(Pizza newPizza){
        super(newPizza);
    }

    public String getName(){

        return tempPizza.getName() + ",Cheese";


    }

    public double getCost()
    {

        return tempPizza.getCost() + 5;

    }
}
