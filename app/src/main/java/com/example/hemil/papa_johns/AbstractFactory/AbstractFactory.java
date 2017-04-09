package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public abstract class AbstractFactory {

    public abstract  Pizza getPizza(String pizzaname, int size, int quantity);
    public abstract Pasta getPasta(String pastaname, int quantity);
	public abstract Drinks getDrinks(String drinkname);
	public abstract Desserts getDesserts(String dessertname);
	public abstract Sandwiches getSandwich(String sandwichname);
	public abstract Sides getSides(String sidename);

}
