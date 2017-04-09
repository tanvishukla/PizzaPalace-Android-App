package com.example.hemil.papa_johns.AbstractFactory;

public class ChickenHabanero_Sandwich implements Sandwiches {

public String getName(){
		
		return "Chicken Habanero";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 7.00*quantity;
		
	}		
	

}
