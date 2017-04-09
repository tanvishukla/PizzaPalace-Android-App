package com.example.hemil.papa_johns.AbstractFactory;

import com.example.hemil.papa_johns.AbstractFactory.AbstractFactory;
import com.example.hemil.papa_johns.AbstractFactory.Brownie;
import com.example.hemil.papa_johns.AbstractFactory.Cake;
import com.example.hemil.papa_johns.AbstractFactory.Coke_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Desserts;
import com.example.hemil.papa_johns.AbstractFactory.DietCoke_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Pasta;
import com.example.hemil.papa_johns.AbstractFactory.Pizza;
import com.example.hemil.papa_johns.AbstractFactory.Sandwiches;
import com.example.hemil.papa_johns.AbstractFactory.Sides;
import com.example.hemil.papa_johns.AbstractFactory.Stix;

public class DessertsFactory extends AbstractFactory {
	


	@Override
	public Pizza getPizza(String pizzaname, int size, int quantity) {
		return null;
	}

	@Override
	public Pasta getPasta(String pastaname, int quantity) {
		return null;
	}

	public Drinks getDrinks(String drinkname) {
	
	return null;
}


public Desserts getDesserts(String dessertname) {
	
	if(dessertname==null)
		return null;
	else if(dessertname.equalsIgnoreCase("Domino's Marbled Cookie Brownie"))
		return new Brownie();
	else if(dessertname.equalsIgnoreCase("Cinna Stix"))
		return new Stix();
	else if(dessertname.equalsIgnoreCase("Chocolate Lava Crunch Cake"))
		return new Cake();
		
	return null;
}


public Sandwiches getSandwich(String sandwichname) {
	// TODO Auto-generated method stub
	return null;
}

	public Sides getSides(String sidename) {
		// TODO Auto-generated method stub
		return null;
	}

}
