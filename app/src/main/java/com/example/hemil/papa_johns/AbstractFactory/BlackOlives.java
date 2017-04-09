package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public class BlackOlives extends ToppingDecorator {
    public BlackOlives(Pizza newPizza){
        super(newPizza);
    }

    public String getName(){

        return tempPizza.getName() + ",Black Olives";


    }

    public double getCost()
    {

        return tempPizza.getCost() + 5;

    }
}
