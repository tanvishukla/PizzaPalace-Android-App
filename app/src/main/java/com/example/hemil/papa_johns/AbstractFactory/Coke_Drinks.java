package com.example.hemil.papa_johns.AbstractFactory;
public class Coke_Drinks implements Drinks {
	
public String getName(){
		
		return "Coke";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 2.37*quantity;
		
	}		

}
