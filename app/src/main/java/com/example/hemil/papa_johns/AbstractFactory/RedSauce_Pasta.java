package com.example.hemil.papa_johns.AbstractFactory;
public class RedSauce_Pasta extends PastaToppingDecorator {
	
	public RedSauce_Pasta(Pasta newPasta) {
		super(newPasta);
		// TODO Auto-generated constructor stub
	}


	public String getName(){

		return tempPasta.getName() + "Red Sauce";


	}

	public double getCost()
	{

		return tempPasta.getCost() + 3;

	}	

}
