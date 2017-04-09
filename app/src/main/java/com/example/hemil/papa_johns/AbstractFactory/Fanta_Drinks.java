package com.example.hemil.papa_johns.AbstractFactory;

public class Fanta_Drinks implements Drinks{
	
public String getName(){
		
		return "Fanta";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 2.35*quantity;
		
	}		

}
