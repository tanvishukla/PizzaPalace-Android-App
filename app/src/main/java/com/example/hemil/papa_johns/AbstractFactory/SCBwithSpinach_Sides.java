package com.example.hemil.papa_johns.AbstractFactory;
public class SCBwithSpinach_Sides implements Sides {
	
public String getName(){
		
		return "Stuffed Cheesy Bread with Spinach and Feta";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 4.39*quantity;
		
	}	


}
