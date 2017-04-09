package com.example.hemil.papa_johns.AbstractFactory;
public class ItalianSP_Sandwich implements Sandwiches {
	
public String getName(){
		
		return "Italian Sausage & Peppers ";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 10.00*quantity;
		
	}	

}
