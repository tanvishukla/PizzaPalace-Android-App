package com.example.hemil.papa_johns.AbstractFactory;
public abstract class PastaToppingDecorator implements Pasta{

	Pasta tempPasta;

	public PastaToppingDecorator(Pasta newPasta){
		tempPasta=newPasta;

	}
}
