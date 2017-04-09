package com.example.hemil.papa_johns.AbstractFactory;

public class ItalianSausageMarinara_Pasta implements Pasta {
	int quantity;

	public ItalianSausageMarinara_Pasta(int quantity){
		this.quantity = quantity;
	}
public String getName(){
		
		return "Italian Sausage Marinara";
		
	}



	public double getCost()
	{
		
		return 10.00*quantity;
		
	}	

}
