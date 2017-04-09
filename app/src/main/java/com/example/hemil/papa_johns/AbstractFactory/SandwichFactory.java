package AbstractFactory;

public class SandwichFactory extends AbstractFactory {
	
public Pizza getPizza(String pizzatype){
			
		return null;
	}
	
public Pasta getPasta(String pastatype){

	return null;
}

public Drinks getDrinks(String drinkname) {
	
	return null;
}


public Desserts getDesserts(String dessertname) {
	
	return null;
}

public Sandwiches getSandwich(String sandwichname) {


	if(sandwichname==null)
		return null;
	else if(sandwichname.equalsIgnoreCase("Italian Sausage & Prppers"))
		return new ItalianSP_Sandwich();
	else if(sandwichname.equalsIgnoreCase("Buffalo Chicken"))
		return new BuffaloChicken_Sandwich();
	else if(sandwichname.equalsIgnoreCase("Chicken Habanero"))
		return new ChickenHabanero_Sandwich();
	else if(sandwichname.equalsIgnoreCase("Mediterranean Veggie"))
		return new MediterraneanVeggie_Sandwich();
	else if(sandwichname.equalsIgnoreCase("Philly Cheese Steak"))
		return new PhillyCheeseSteak_Sandwich();
	
	
	return null;
}

	

}
