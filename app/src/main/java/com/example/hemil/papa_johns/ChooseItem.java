package com.example.hemil.papa_johns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.AbstractFactory.Pizza;
import com.example.hemil.papa_johns.Utility.ItemListAdapter;

import org.w3c.dom.Text;

/**
 * Created by hemil on 11/18/2015.
 */
public class ChooseItem extends AppCompatActivity {

     String[] chooseItemList_pizza = {
        "Spinach & Feto Pizza","Winsconsin 6 Cheese Pizza","Pacific Veggie Pizza","Memphis BBQ Chicken Pizza",
             "Ultimate Pepperoni Feast Pizza"
    };

    String[] chooseItemList_sand = {
        "Italian Sausage & Peppers", "Buffalo Chicken","Chicken Habanero", "Mediterranean Veggie", "Philly Cheese Steak"
    };

    String[] chooseItemList_pasta = {
        "Chicken Alfredo", "Italian Sausage Marinara", "Chicken Carbonara", "Pasta Primavera"
    };

    String[] chooseItemList_drink = {
        "Coke", "Diet Coke", "Sprite", "Dasani Bottle Water", "Barq`s Root Beer", "Fanta"
    };

    String[] chooseItemList_dessert = {
        "Domino's Marbled Cookie Brownie", "Cinna Stix", "Chocolate Lava Crunch Cake"
    };

    String[] chooseItemList_side = {
        "Stuffed Cheesy Bread", "Stuffed Cheesy Bread with Spinach & Feta", "Stuffed Cheesy Bread with Bacon & Jalapeno",
            "Parmesan Bread Bites", "Breadsticks"
    };


     int[] mThumbsId_pizza = {
        R.drawable.spinach_fetta_pizza,R.drawable.winsconsin_6_cheese_pizza,R.drawable.pacific_veggie_pizza,
             R.drawable.memphis_bbq_chicken_pizza,R.drawable.ultimate_pepperoni_feast_pizza
    };

    int[] mThumbsId_sand = {
        R.drawable.italian_sausage_peppers, R.drawable.buffalo_chicken, R.drawable.chicken_hanbero,
            R.drawable.mediterranean_veggie, R.drawable.philly_cheese_steak
    };

    int[] mThumbsId_pasta = {
        R.drawable.chicken_alfredo, R.drawable.italian_sausage_marinara, R.drawable.chicken_carbonara,
            R.drawable.pasta_primavera
    };

    int[] mThumbsId_drink = {
        R.drawable.coke, R.drawable.diet_coke, R.drawable.sprite, R.drawable.dasani_water_bottle,
            R.drawable.barqs_root_beer, R.drawable.fanta
    };

    int[] mThumbsId_dessert = {
        R.drawable.brownie, R.drawable.stix, R.drawable.cake
    };

    int[] mThumbsId_side = {
        R.drawable.bread, R.drawable.bread_spinach_fetta, R.drawable.bread_bacon_jalapeno,R.drawable.parmesan_bread_bites,
            R.drawable.breadsticks
    };


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_item);

        ListView listView = (ListView) findViewById(R.id.chooseItemListView);
        final int itemPosition = getIntent().getExtras().getInt("position");

        TextView chooseItemTitle = (TextView) findViewById(R.id.itemCategory);
        TextView dominosItem = (TextView) findViewById(R.id.dominosItem);

        switch(itemPosition){
            case 0 :    chooseItemTitle.setText("Pizzas");
                        dominosItem.setText("Domino`s Pizzas");
                        listView.setAdapter(new ItemListAdapter(this, chooseItemList_pizza, mThumbsId_pizza));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_pizza[position]);
                        intent.putExtra("Position", position);
                        intent.putExtra("MenuItem", itemPosition);
                        Toast.makeText(ChooseItem.this, "" + position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
            case 1 :    chooseItemTitle.setText("Sandwiches");
                        dominosItem.setText("Domino`s Sandwiches");
                        listView.setAdapter(new ItemListAdapter(this, chooseItemList_sand, mThumbsId_sand));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_sand[position]);
                        intent.putExtra("Position", position);
                        intent.putExtra("MenuItem", itemPosition);
                        Toast.makeText(ChooseItem.this, "" + position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
            case 2:
                chooseItemTitle.setText("Pastas");
                dominosItem.setText("Domino`s Pastas");
                listView.setAdapter(new ItemListAdapter(this, chooseItemList_pasta, mThumbsId_pasta));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_pasta[position]);
                        intent.putExtra("Position",position);
                        intent.putExtra("MenuItem",itemPosition);
                        Toast.makeText(ChooseItem.this, ""+position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
            case 3 :    chooseItemTitle.setText("Drinks");
                        dominosItem.setText("Domino`s Drinks");
                        listView.setAdapter(new ItemListAdapter(this, chooseItemList_drink, mThumbsId_drink));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_drink[position]);
                        intent.putExtra("Position", position);
                        intent.putExtra("MenuItem", itemPosition);
                        Toast.makeText(ChooseItem.this, "" + position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
            case 4 :    chooseItemTitle.setText("Desserts");
                        dominosItem.setText("Domino`s Desserts");
                        listView.setAdapter(new ItemListAdapter(this, chooseItemList_dessert, mThumbsId_dessert));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_dessert[position]);
                        intent.putExtra("Position", position);
                        intent.putExtra("MenuItem", itemPosition);
                        Toast.makeText(ChooseItem.this, "" + position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
            case 5 :    chooseItemTitle.setText("Sides");
                        dominosItem.setText("Domino`s sides");
                        listView.setAdapter(new ItemListAdapter(this, chooseItemList_side, mThumbsId_side));
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        //       Toast.makeText(ChooseItem.this, ""+chooseItemList_pizza[position], Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(getApplicationContext(), PizzaScreenOne.class);
                        intent.putExtra("PizzaName", chooseItemList_side[position]);
                        intent.putExtra("Position", position);
                        intent.putExtra("MenuItem", itemPosition);
                        Toast.makeText(ChooseItem.this, "" + position, Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                        ChooseItem.this.finish();
                    }
                });
                break;
        }

    }
}
