package com.example.hemil.papa_johns.AbstractFactory;

import com.example.hemil.papa_johns.AbstractFactory.Pasta;

public class ChickenAlfredo_Pasta implements Pasta {

	int quantity;
	public ChickenAlfredo_Pasta(int quantity){
		this.quantity = quantity;
	}

public String getName(){

		
		return "Chicken Alfredo";
		
	}
	
	public double getCost()
	{
		
		return 8.00*quantity;
		
	}	
	
	
}
