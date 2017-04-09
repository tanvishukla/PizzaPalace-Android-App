package com.example.hemil.papa_johns.AbstractFactory;

public class Breadsticks_Sides implements Sides {
	
public String getName(){
		
		return "Breadsticks";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 3.00*quantity;
		
	}	


}
