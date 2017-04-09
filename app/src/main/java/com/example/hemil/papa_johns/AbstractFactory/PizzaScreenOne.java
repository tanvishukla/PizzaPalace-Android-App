package com.example.hemil.papa_johns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.AbstractFactory.AbstractFactory;
import com.example.hemil.papa_johns.AbstractFactory.BarqRootBeer_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Breadsticks_Sides;
import com.example.hemil.papa_johns.AbstractFactory.Brownie;
import com.example.hemil.papa_johns.AbstractFactory.BuffaloChicken_Sandwich;
import com.example.hemil.papa_johns.AbstractFactory.Cake;
import com.example.hemil.papa_johns.AbstractFactory.ChickenHabanero_Sandwich;
import com.example.hemil.papa_johns.AbstractFactory.Coke_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.DasaniWater_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Desserts;
import com.example.hemil.papa_johns.AbstractFactory.DietCoke_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Drinks;
import com.example.hemil.papa_johns.AbstractFactory.FactoryProducer;
import com.example.hemil.papa_johns.AbstractFactory.Fanta_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.ItalianSP_Sandwich;
import com.example.hemil.papa_johns.AbstractFactory.MediterraneanVeggie_Sandwich;
import com.example.hemil.papa_johns.AbstractFactory.ParmesanBreadBites_Sides;
import com.example.hemil.papa_johns.AbstractFactory.Pasta;
import com.example.hemil.papa_johns.AbstractFactory.PhillyCheeseSteak_Sandwich;
import com.example.hemil.papa_johns.AbstractFactory.Pizza;
import com.example.hemil.papa_johns.AbstractFactory.RedSauce_Pasta;
import com.example.hemil.papa_johns.AbstractFactory.SCBwithSpinach_Sides;
import com.example.hemil.papa_johns.AbstractFactory.STBwithBacon_Sides;
import com.example.hemil.papa_johns.AbstractFactory.Sandwiches;
import com.example.hemil.papa_johns.AbstractFactory.Sides;
import com.example.hemil.papa_johns.AbstractFactory.Sprite_Drinks;
import com.example.hemil.papa_johns.AbstractFactory.Stix;
import com.example.hemil.papa_johns.AbstractFactory.StuffedCheesyBread_Sides;
import com.example.hemil.papa_johns.AbstractFactory.WhiteSauce_Pasta;
import com.example.hemil.papa_johns.Memento.Ocaretaker;
import com.example.hemil.papa_johns.Memento.Omemento;
import com.example.hemil.papa_johns.Memento.Ooriginator;
import com.example.hemil.papa_johns.POJO.Order;
import com.example.hemil.papa_johns.Utility.ItemListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemil on 11/28/2015.
 */
public class PizzaScreenOne extends AppCompatActivity {

    TextView quantityText;
    AbstractFactory af;
    RadioGroup radioGroup, radioGroup2;
    TextView text;
    int itemPosition;

    Order order;
    Ooriginator originator = new Ooriginator();
    Ocaretaker ocareTaker = new Ocaretaker();
    List<Omemento> list = ocareTaker.getList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        itemPosition = getIntent().getExtras().getInt("MenuItem");
        Toast.makeText(PizzaScreenOne.this, "Menu Item : "+itemPosition, Toast.LENGTH_SHORT).show();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_screen_one);
        radioGroup = (RadioGroup) findViewById(R.id.sizeRadioGroup);
        radioGroup2 = (RadioGroup) findViewById(R.id.pastaRadioGroup);
        text = (TextView) findViewById(R.id.selected_Pizza_Name);

        switch(itemPosition){
            case 0 :
                      text.setText(getIntent().getExtras().getString("PizzaName"));
                      break;

            case 2 :    text.setText(getIntent().getExtras().getString("PizzaName"));
                        radioGroup.setVisibility(View.GONE);
                        radioGroup2.setVisibility(View.VISIBLE);
                        break;

            case 1 :
            case 3 :
            case 4 :
            case 5 :    TextView set = (TextView) findViewById(R.id.select_sizeText);
                        set.setVisibility(View.GONE);
                        text.setText(getIntent().getExtras().getString("PizzaName"));
                        radioGroup.setVisibility(View.GONE);
                        radioGroup2.setVisibility(View.GONE);
                        break;
        }

        quantityText = (TextView) findViewById(R.id.quantityText);
        quantityText.setText("0");
    }

    public void decQuantity(View view){
        int value = Integer.parseInt(quantityText.getText().toString());
        if(value>0){
            value = value -1;
            quantityText.setText(""+value);
   //         Toast.makeText(PizzaScreenOne.this, ""+value, Toast.LENGTH_SHORT).show();
        }
    }

    public void incQuantity(View view){
        Integer value = Integer.parseInt(quantityText.getText().toString());
        value = value +1;
            quantityText.setText(""+value);
    //    Toast.makeText(PizzaScreenOne.this, ""+value, Toast.LENGTH_SHORT).show();

    }

    public void ContinueOrderMethod(View view){

        switch (itemPosition){
            case 0 : pizzaEvent(); break;
           case 2 : pastaEvent(); break;
            case 1 : sandwichEvent(); break;
            case 3 : drinksEvent(); break;
           case 4 : dessertsEvent(); break;
            case 5 : sidesEvent(); break;
        }
    }

    public void pizzaEvent(){
        int value = Integer.parseInt(quantityText.getText().toString());
        int id = -1;
        if(!( radioGroup.getCheckedRadioButtonId() == -1)){
            if(((RadioButton) findViewById(R.id.small)).isChecked()){
                id =1;
            }
            if(((RadioButton) findViewById(R.id.medium)).isChecked()){
                id =2;
            }
            if(((RadioButton) findViewById(R.id.large)).isChecked()){
                id =3;
            }
        }
        if(value<=0 || id<0)
        {
            Toast.makeText(PizzaScreenOne.this, ""+"Please select size and quantity ", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(PizzaScreenOne.this, "Size :"+id+" Quantity : "+value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(),PizzaScreenTwo.class);
            intent.putExtra("PizzaName", getIntent().getExtras().getString("PizzaName"));
            intent.putExtra("PizzaSize", id);
            intent.putExtra("PizzaQuantity", value);



            switch (getIntent().getExtras().getInt("Position")) {
                case 0 :
              /*      af = FactoryProducer.getFactory("Pizza");
                    Pizza p1 = af.getPizza("Spinach Pizza", id, value);
                    Toast.makeText(PizzaScreenOne.this, ""+p1.getCost() , Toast.LENGTH_SHORT).show();   */
                    intent.putExtra("getPizza","Spinach Pizza");
                    break;
                case 1 :
              /*      af = FactoryProducer.getFactory("Pizza");
                    Pizza p2 = af.getPizza("Winsconsin 6 Cheeze Pizza", id, value);
                    Toast.makeText(PizzaScreenOne.this, ""+p2.getCost() , Toast.LENGTH_SHORT).show();   */
                    intent.putExtra("getPizza","Winsconsin 6 Cheeze Pizza");
                    break;

                case 2 :
              /*      af = FactoryProducer.getFactory("Pizza");
                    Pizza p3 = af.getPizza("Pacific Veggie Pizza", id, value);
                    Toast.makeText(PizzaScreenOne.this, ""+p3.getCost() , Toast.LENGTH_SHORT).show();   */
                    intent.putExtra("getPizza","Pacific Veggie Pizza");
                    break;
                case 3 :
              /*      af = FactoryProducer.getFactory("Pizza");
                    Pizza p4 = af.getPizza("Memphis BBQ Chicken Pizza", id, value);
                    Toast.makeText(PizzaScreenOne.this, ""+p4.getCost() , Toast.LENGTH_SHORT).show();   */
                    intent.putExtra("getPizza","Memphis BBQ Chicken Pizza");
                    break;
                case 4 :
              /*      af = FactoryProducer.getFactory("Pizza");
                    Pizza p5 = af.getPizza("Ultimate Pepperoni Feast Pizza", id, value);
                    Toast.makeText(PizzaScreenOne.this, ""+p5.getCost() , Toast.LENGTH_SHORT).show();   */
                    intent.putExtra("getPizza","Ultimate Pepperoni Feast Pizza");
                    break;
            }

            startActivity(intent);
            this.finish();
        }
    }

    public void pastaEvent() {
        int value = Integer.parseInt(quantityText.getText().toString());
        int id = -1;
        if (!(radioGroup2.getCheckedRadioButtonId() == -1)) {
            if (((RadioButton) findViewById(R.id.whiteSauce)).isChecked()) {
                id = 1;
            }
            if (((RadioButton) findViewById(R.id.redSauce)).isChecked()) {
                id = 2;
            }
        }
        if (value <= 0 || id < 0) {
            Toast.makeText(PizzaScreenOne.this, "" + " select size and quantity ", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(PizzaScreenOne.this, "Sauce :" + id + " Quantity : " + value, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);

            AbstractFactory af2 = FactoryProducer.getFactory("Pasta");
            Pasta p2 = af2.getPasta(getIntent().getExtras().getString("PizzaName"), value);

            Pasta temp = p2;

            switch (id){
                case 1 : temp = new WhiteSauce_Pasta(temp); break;
                case 2 : temp = new RedSauce_Pasta(temp); break;
            }

            Toast.makeText(PizzaScreenOne.this, ""+temp.getName()+"  "+temp.getCost(), Toast.LENGTH_SHORT).show();

            order = new Order(temp.getName(),temp.getCost());
            originator.setState(order);
            ocareTaker.add(originator.saveStateToMemento());
            for(int i =0;i<list.size();i++){
                Log.d("Order", list.get(i).getState().getOrderName());
            }
            startActivity(intent);
            this.finish();
        }
    }

    public void sandwichEvent(){
        int value = Integer.parseInt(quantityText.getText().toString());
        if (value <= 0 ) {
            Toast.makeText(PizzaScreenOne.this, "" + " select quantity ", Toast.LENGTH_SHORT).show();
        } else {

            Sandwiches sand = null;

            switch (getIntent().getExtras().getInt("Position")){
                case 0 : sand = new ItalianSP_Sandwich(); break;
                case 1 : sand = new BuffaloChicken_Sandwich(); break;
                case 2 : sand = new ChickenHabanero_Sandwich(); break;
                case 3 : sand = new MediterraneanVeggie_Sandwich(); break;
                case 4 : sand = new PhillyCheeseSteak_Sandwich(); break;
            }

            order = new Order(sand.getName(),sand.getCost(value));
            originator.setState(order);
            ocareTaker.add(originator.saveStateToMemento());
            for(int i =0;i<list.size();i++){
                Log.d("Order", list.get(i).getState().getOrderName());
            }
            Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);
            startActivity(intent);
        }
    }

    public void drinksEvent(){
        int value = Integer.parseInt(quantityText.getText().toString());
        if (value <= 0 ) {
            Toast.makeText(PizzaScreenOne.this, "" + " select quantity ", Toast.LENGTH_SHORT).show();
        } else {
            Drinks drink = null;

            switch (getIntent().getExtras().getInt("Position")){
                case 0 : drink = new Coke_Drinks(); break;
                case 1 : drink = new DietCoke_Drinks(); break;
                case 2 : drink = new Sprite_Drinks(); break;
                case 3 : drink = new DasaniWater_Drinks(); break;
                case 4 : drink = new BarqRootBeer_Drinks(); break;
                case 5 : drink = new Fanta_Drinks(); break;
            }

            order = new Order(drink.getName(),drink.getCost(value));
            originator.setState(order);
            ocareTaker.add(originator.saveStateToMemento());
            for(int i =0;i<list.size();i++){
                Log.d("Order", list.get(i).getState().getOrderName());
            }
            Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);
            startActivity(intent);
        }
    }

    public void dessertsEvent(){
        int value = Integer.parseInt(quantityText.getText().toString());
        if (value <= 0 ) {
            Toast.makeText(PizzaScreenOne.this, "" + " select quantity ", Toast.LENGTH_SHORT).show();
        } else {
            Desserts dessert = null;

            switch (getIntent().getExtras().getInt("Position")){
                case 0 :
                case 1 : dessert = new Brownie(); break;
                case 2 : dessert = new Stix(); break;
                case 3 : dessert = new Cake(); break;

            }

            order = new Order(dessert.getName(),dessert.getCost(value));
            originator.setState(order);
            ocareTaker.add(originator.saveStateToMemento());
            for(int i =0;i<list.size();i++){
                Log.d("Order", list.get(i).getState().getOrderName());
            }
            Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);
            startActivity(intent);
        }
    }

    public void sidesEvent(){
        int value = Integer.parseInt(quantityText.getText().toString());
        if (value <= 0 ) {
            Toast.makeText(PizzaScreenOne.this, "" + " select quantity ", Toast.LENGTH_SHORT).show();
        } else {
            Sides side = null;

            switch (getIntent().getExtras().getInt("Position")){
                case 0 : side = new StuffedCheesyBread_Sides(); break;
                case 1 : side = new SCBwithSpinach_Sides(); break;
                case 2 : side = new STBwithBacon_Sides(); break;
                case 3 : side = new ParmesanBreadBites_Sides(); break;
                case 4 : side = new Breadsticks_Sides(); break;
            }

            order = new Order(side.getName(),side.getCost(value));
            originator.setState(order);
            ocareTaker.add(originator.saveStateToMemento());
            for(int i =0;i<list.size();i++){
                Log.d("Order", list.get(i).getState().getOrderName());
            }
            Intent intent = new Intent(getApplicationContext(), PlaceOrder.class);
            startActivity(intent);
        }

    }
}
