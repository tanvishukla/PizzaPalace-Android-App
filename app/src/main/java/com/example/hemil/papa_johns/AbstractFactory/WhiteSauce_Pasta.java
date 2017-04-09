package com.example.hemil.papa_johns.AbstractFactory;
public class WhiteSauce_Pasta extends PastaToppingDecorator {

	public WhiteSauce_Pasta(Pasta newPasta) {
		super(newPasta);
		// TODO Auto-generated constructor stub
	}


	public String getName(){

		return tempPasta.getName() + "White Sauce";


	}

	public double getCost()
	{

		return tempPasta.getCost() + 5;

	}	
}


