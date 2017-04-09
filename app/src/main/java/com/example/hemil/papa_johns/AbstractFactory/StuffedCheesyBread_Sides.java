package com.example.hemil.papa_johns.AbstractFactory;

public class StuffedCheesyBread_Sides  implements  Sides{
	
public String getName(){
		
		return "Stuffed Cheesy Bread";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 5.00*quantity;
		
	}	

}
