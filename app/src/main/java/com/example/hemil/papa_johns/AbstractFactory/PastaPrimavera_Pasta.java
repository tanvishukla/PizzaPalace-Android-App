package com.example.hemil.papa_johns.AbstractFactory;

public class PastaPrimavera_Pasta implements Pasta {

	int quantity;

	public PastaPrimavera_Pasta(int quantity){
		this.quantity = quantity;
	}

public String getName(){
		
		return "Pasta Primavera";
		
	}
	
	public double getCost()
	{
		
		return 8.00*quantity;
		
	}	
	
}
