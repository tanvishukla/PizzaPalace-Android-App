package com.example.hemil.papa_johns.AbstractFactory;

public class DietCoke_Drinks implements Drinks{
	
public String getName(){
		
		return "Diet Coke";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 1.99*quantity;
		
	}		

}
