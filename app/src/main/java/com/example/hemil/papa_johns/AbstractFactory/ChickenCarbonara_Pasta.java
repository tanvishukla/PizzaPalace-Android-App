package com.example.hemil.papa_johns.AbstractFactory;

public class ChickenCarbonara_Pasta implements Pasta {

	int quantity;

	public ChickenCarbonara_Pasta(int quantity){
		this.quantity = quantity;
	}

public String getName(){
		
		return "Chicken Carbonara";
		
	}
	
	public double getCost()
	{
		
		return 9.00*quantity;
		
	}	

}
