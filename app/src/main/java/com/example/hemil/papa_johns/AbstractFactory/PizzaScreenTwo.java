package com.example.hemil.papa_johns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.AbstractFactory.AbstractFactory;
import com.example.hemil.papa_johns.AbstractFactory.BlackOlives;
import com.example.hemil.papa_johns.AbstractFactory.Cheese;
import com.example.hemil.papa_johns.AbstractFactory.ChipotleSauce;
import com.example.hemil.papa_johns.AbstractFactory.FactoryProducer;
import com.example.hemil.papa_johns.AbstractFactory.Garlic;
import com.example.hemil.papa_johns.AbstractFactory.Onions;
import com.example.hemil.papa_johns.AbstractFactory.Pasta;
import com.example.hemil.papa_johns.AbstractFactory.Pizza;
import com.example.hemil.papa_johns.Memento.CareTaker;
import com.example.hemil.papa_johns.Memento.Memento;
import com.example.hemil.papa_johns.Memento.Ocaretaker;
import com.example.hemil.papa_johns.Memento.Omemento;
import com.example.hemil.papa_johns.Memento.Ooriginator;
import com.example.hemil.papa_johns.Memento.Originator;
import com.example.hemil.papa_johns.POJO.Order;

import java.util.List;

/**
 * Created by hemil on 11/28/2015.
 */
public class PizzaScreenTwo extends AppCompatActivity {

    String[] str = {"Cheese", "Sausage"};
    int[] mThumbId = { R.drawable.breadsticks, R.drawable.bread};
    Pizza p1;
    Pasta p2;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_screen_two);
        TextView pizzaName = (TextView) findViewById(R.id.selected_Pizza_Name);
        TextView pizaaQuantity = (TextView) findViewById(R.id.selectedPizzaQuantity);
        TextView pizzaSize = (TextView) findViewById(R.id.selectedPizzaSize);
      //  listView = (ListView) findViewById(R.id.toppingsListView);
        pizzaName.setText(getIntent().getExtras().getString("PizzaName"));
        pizzaSize.setText(""+getIntent().getExtras().getInt("PizzaSize"));
        pizaaQuantity.setText(""+getIntent().getExtras().getInt("PizzaQuantity"));

        AbstractFactory af = FactoryProducer.getFactory("Pizza");
        p1 = af.getPizza(getIntent().getExtras().getString("getPizza"), getIntent().getExtras().getInt("PizzaSize"), getIntent().getExtras().getInt("PizzaQuantity"));


    //    listView.setAdapter(new ToppingsListAdapter(this,str,mThumbId,p1));
    }


    public void addToCartMethod(View view){

        Pizza temp = p1;
        if(((CheckBox) findViewById(R.id.toppingCheckbox1)).isChecked()){
            temp = new Cheese(temp);
        }
        if(((CheckBox) findViewById(R.id.toppingCheckbox2)).isChecked()){
            temp = new Onions(temp);
        }
        if(((CheckBox) findViewById(R.id.toppingCheckbox3)).isChecked()){
            temp = new Garlic(temp);
        }
        if(((CheckBox) findViewById(R.id.toppingCheckbox4)).isChecked()){
            temp = new ChipotleSauce(temp);
        }
        if(((CheckBox) findViewById(R.id.toppingCheckbox5)).isChecked()){
            temp = new BlackOlives(temp);
        }

        Toast.makeText(PizzaScreenTwo.this, temp.getName() + "   " + temp.getCost(), Toast.LENGTH_SHORT).show();

        Order order = new Order(temp.getName(),temp.getCost());

        Ooriginator originator = new Ooriginator();
        originator.setState(order);

        Ocaretaker ocareTaker = new Ocaretaker();
        ocareTaker.add(originator.saveStateToMemento());

        List<Omemento> lst = ocareTaker.getList();
        for(int i =0;i<lst.size();i++){
            Log.d("Order",lst.get(i).getState().getOrderName());
        }
        Intent intent = new Intent(this,PlaceOrder.class);
        startActivity(intent);
        this.finish();
    }
}
