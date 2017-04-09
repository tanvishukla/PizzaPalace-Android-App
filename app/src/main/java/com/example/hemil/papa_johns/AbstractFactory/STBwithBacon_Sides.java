package com.example.hemil.papa_johns.AbstractFactory;
public class STBwithBacon_Sides implements Sides{
	
public String getName(){
		
		return "Stuffed Cheesy Bread with Bacon & Jalapeno";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 4.00*quantity;
		
	}	


}
