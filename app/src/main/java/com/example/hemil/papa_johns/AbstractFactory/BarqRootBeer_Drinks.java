package com.example.hemil.papa_johns.AbstractFactory;

public class BarqRootBeer_Drinks implements Drinks {
	
public String getName(){
		
		return "Barq's Root Beer";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 3.25*quantity;
		
	}		

}
