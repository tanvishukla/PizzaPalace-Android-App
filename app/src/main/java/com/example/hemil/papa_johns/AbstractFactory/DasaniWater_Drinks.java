package com.example.hemil.papa_johns.AbstractFactory;

public class DasaniWater_Drinks implements Drinks{
	
public String getName(){
		
		return "Dasani Water Bottle";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 1.90*quantity;
		
	}		

}
