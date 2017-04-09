package com.example.hemil.papa_johns.AbstractFactory;

public class Sprite_Drinks implements Drinks{
	
public String getName(){
		
		return "Sprite";
		
	}
	
	public double getCost(int quantity)
	{
		
		return 2.09*quantity;
		
	}		

}
