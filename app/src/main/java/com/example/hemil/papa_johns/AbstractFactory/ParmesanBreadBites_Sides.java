package com.example.hemil.papa_johns.AbstractFactory;

public class ParmesanBreadBites_Sides implements Sides {
	
public String getName(){
		
		return "Parmesan Bread Bites";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 6.00*quantity;
		
	}	


}
