package com.example.hemil.papa_johns.AbstractFactory;

public class BuffaloChicken_Sandwich implements Sandwiches {

public String getName(){
		
		return "Buffalo Chicken";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 9.00*quantity;
		
	}	
	
}
