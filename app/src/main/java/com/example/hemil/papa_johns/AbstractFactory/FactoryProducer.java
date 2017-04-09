package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class FactoryProducer {

    public static AbstractFactory getFactory(String factory){

        if(factory.equalsIgnoreCase("Pizza")){

            return new PizzaFactory();

        }

        else if(factory.equalsIgnoreCase("Pasta")){

            return new PastaFactory();
        }

        return null;

    }
}
