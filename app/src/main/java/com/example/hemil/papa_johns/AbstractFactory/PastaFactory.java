package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class PastaFactory extends AbstractFactory{

    public Pizza getPizza(String pizzatype,int size, int quantity){
        return null;
    }


    @Override
    public Pasta getPasta(String pastaname, int quantity) {

        if(pastaname==null)
            return null;
        else if(pastaname.equalsIgnoreCase("Chicken Alfredo"))
            return new ChickenAlfredo_Pasta(quantity);
        else if(pastaname.equalsIgnoreCase("Italian Sausage Marinara"))
            return new ItalianSausageMarinara_Pasta(quantity);
        else if(pastaname.equalsIgnoreCase("Chicken Carbonara"))
            return new ChickenCarbonara_Pasta(quantity);
        else if(pastaname.equalsIgnoreCase("Pasta Primavera"))
            return new PastaPrimavera_Pasta(quantity);
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
	

}
