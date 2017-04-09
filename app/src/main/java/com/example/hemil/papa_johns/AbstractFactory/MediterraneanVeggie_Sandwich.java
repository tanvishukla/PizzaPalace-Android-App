package com.example.hemil.papa_johns.AbstractFactory;
public class MediterraneanVeggie_Sandwich implements Sandwiches {
	
public String getName(){
		
		return "Mediterranean Veggie";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 10.00*quantity;
		
	}	

}
