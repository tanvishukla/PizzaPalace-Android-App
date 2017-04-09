package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 12/5/2015.
 */
public class SidesFactory extends AbstractFactory {
    @Override
    public Pizza getPizza(String pizzaname, int size, int quantity) {
        return null;
    }

    @Override
    public Pasta getPasta(String pastaname, int quantity) {
        return null;
    }

    @Override
    public Drinks getDrinks(String drinkname) {
        return null;
    }

    @Override
    public Desserts getDesserts(String dessertname) {
        return null;
    }

    @Override
    public Sandwiches getSandwich(String sandwichname) {
        return null;
    }

    @Override
    public Sides getSides(String sidename){
        if(sidename==null)
            return null;
        else if(sidename.equalsIgnoreCase("Stuffed Cheesy Bread"))
            return new Breadsticks_Sides();
        else if(sidename.equalsIgnoreCase("Stuffed Cheesy Bread with Spinach & Feta"))
            return new SCBwithSpinach_Sides();
        else if(sidename.equalsIgnoreCase("Stuffed Cheesy Bread with Becon & Jalapeno"))
            return new STBwithBacon_Sides();
        else if(sidename.equalsIgnoreCase("Permesan Bread Bites"))
            return new ParmesanBreadBites_Sides();
        else if(sidename.equalsIgnoreCase("Breadsticks"))
            return new Breadsticks_Sides();

        return null;
    }
}
