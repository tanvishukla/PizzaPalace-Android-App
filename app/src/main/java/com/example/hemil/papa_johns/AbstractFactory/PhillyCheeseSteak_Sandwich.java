package com.example.hemil.papa_johns.AbstractFactory;

public class PhillyCheeseSteak_Sandwich implements Sandwiches {
	
public String getName(){
		
		return "Philly Cheese Steak";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 8.00*quantity;
		
	}	

}
