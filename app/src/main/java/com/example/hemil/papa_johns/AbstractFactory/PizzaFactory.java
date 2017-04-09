package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class PizzaFactory extends AbstractFactory{

    public Pizza getPizza(String pizzatype, int size, int quantity){

        if(pizzatype==null)
            return null;
        else if(pizzatype.equalsIgnoreCase("Spinach Pizza"))
            return new Spinach_Fetta(size,quantity);
        else if(pizzatype.equalsIgnoreCase("Winsconsin 6 Cheeze Pizza"))
            return new Winsconsin(size,quantity);
        else if(pizzatype.equalsIgnoreCase("Pacific Veggie Pizza"))
            return new Pacific_Veggie(size,quantity);
        else if(pizzatype.equalsIgnoreCase("Memphis BBQ Chicken Pizza"))
            return new Memphis_BBQ(size,quantity);
        else if(pizzatype.equalsIgnoreCase("Ultimate Pepperoni Feast Pizza"))
            return new Pepperoni(size,quantity);

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
	
	return null;
}


public Sandwiches getSandwich(String sandwichname) {
	
	return null;
}

    @Override
    public Sides getSides(String sidename) {
        return null;
    }


}
