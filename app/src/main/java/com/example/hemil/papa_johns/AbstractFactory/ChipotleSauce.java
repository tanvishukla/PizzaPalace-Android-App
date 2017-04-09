package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/29/2015.
 */
public class ChipotleSauce extends ToppingDecorator {
    public ChipotleSauce(Pizza newPizza){
        super(newPizza);
    }

    public String getName(){

        return tempPizza.getName() + ",Chipotle Sauce";


    }

    public double getCost()
    {

        return tempPizza.getCost() + 3;

    }
}
