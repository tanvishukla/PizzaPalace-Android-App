package AbstractFactory;

public class DrinksFactory extends AbstractFactory {
	
public Pizza getPizza(String pizzatype){
			
		return null;
	}
	
public Pasta getPasta(String pastatype){

	return null;
}

public Drinks getDrinks(String drinkname) {
	
	if(drinkname==null)
		return null;
	else if(drinkname.equalsIgnoreCase("Coke"))
		return new Coke_Drinks();
	else if(drinkname.equalsIgnoreCase("Diet Coke"))
		return new DietCoke_Drinks();
	else if(drinkname.equalsIgnoreCase("Sprite"))
		return new Sprite_Drinks();
	else if(drinkname.equalsIgnoreCase("Dasani Bottle Water"))
		return new DasaniWater_Drinks();
	else if(drinkname.equalsIgnoreCase("Barq's Root Beer"))
		return new BarqRootBeer_Drinks();
	else if(drinkname.equalsIgnoreCase("Fanta"))
		return new Fanta_Drinks();
	
	
	return null;
}


public Desserts getDesserts(String dessertname) {
	// TODO Auto-generated method stub
	return null;
}


public Sandwiches getSandwich(String sandwichname) {
	// TODO Auto-generated method stub
	return null;
}

	

}
