package com.example.hemil.papa_johns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.hemil.papa_johns.AbstractFactory.AbstractFactory;
import com.example.hemil.papa_johns.AbstractFactory.FactoryProducer;
import com.example.hemil.papa_johns.R;
import com.example.hemil.papa_johns.Utility.MenuGridAdapter;

/**
 * Created by hemil on 11/17/2015.
 */
public class MenuScreen extends AppCompatActivity {

    int[] imageResource = {
        R.drawable.menu_1_pizzas, R.drawable.menu_2_sandwitches, R.drawable.menu_3_pastas,
            R.drawable.menu_4_drinks, R.drawable.menu_5_desserts, R.drawable.menu_6_sides
    };

    String[] menuItemText = {
      "Pizzas", "Sandwitches", "Pastas", "Drinks", "Desserts", "Sides"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_screen);

        GridView gridView = (GridView) (findViewById(R.id.mainMenuGrid));
        gridView.setAdapter(new MenuGridAdapter(this,menuItemText,imageResource));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                category(position);
            }
        });
    }

    public void category(int position){

        switch (position){
            case 0 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_pizza = new Intent(this,ChooseItem.class);
                            intent_pizza.putExtra("position",position);
                            startActivity(intent_pizza);
                            break;
            case 1 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_sand = new Intent(this,ChooseItem.class);
                            intent_sand.putExtra("position",position);
                            startActivity(intent_sand);

                            break;
            case 2 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_pasta = new Intent(this,ChooseItem.class);
                            intent_pasta.putExtra("position",position);
                            startActivity(intent_pasta);

                            break;
            case 3 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_drink = new Intent(this,ChooseItem.class);
                            intent_drink.putExtra("position",position);
                            startActivity(intent_drink);
                            break;
            case 4 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_dessert = new Intent(this,ChooseItem.class);
                            intent_dessert.putExtra("position",position);
                            startActivity(intent_dessert);
                            break;
            case 5 :        Toast.makeText(MenuScreen.this,""+ position, Toast.LENGTH_SHORT).show();
                            Intent intent_side = new Intent(this,ChooseItem.class);
                            intent_side.putExtra("position",position);
                            startActivity(intent_side);
                            break;
        }
    }

}
