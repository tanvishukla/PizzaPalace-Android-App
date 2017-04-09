package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public class Onions extends ToppingDecorator {
    public Onions(Pizza newPizza){
        super(newPizza);
    }

    public String getName(){

        return tempPizza.getName() + ",Onions";


    }

    public double getCost()
    {

        return tempPizza.getCost() + 2;

    }
}
