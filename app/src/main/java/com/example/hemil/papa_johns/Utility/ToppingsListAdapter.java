package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.AbstractFactory.Pizza;
import com.example.hemil.papa_johns.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemil on 11/28/2015.
 */
public class ToppingsListAdapter extends BaseAdapter {

    private Context context;
    private String[] chooseToppingList;
    private int[] chooseTopingsImage;
    Pizza pizza;
    List<String> selectedTopping = new ArrayList<String>();

    public ToppingsListAdapter(Context context, String[] chooseToppingList, int[] chooseTopingsImage,Pizza pizza){
        this.context = context;
        this.chooseToppingList = chooseToppingList;
        this.chooseTopingsImage = chooseTopingsImage;
        this.pizza = pizza;
    }

    public int getCount(){  return chooseTopingsImage.length;    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return 0;
    }

    public View getView(final int position, View convertView, ViewGroup parent){
        View list;
        final CheckBox checkBox;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(convertView==null){
            list = new View(context);
            list = inflater.inflate(R.layout.toppings_listview_single,null);
            ImageView imageView = (ImageView) list.findViewById(R.id.toppingsImage);
            TextView textView = (TextView) list.findViewById(R.id.toppingsText);
            imageView.setImageResource(chooseTopingsImage[position]);
            textView.setText(chooseToppingList[position]);

        }
        else list = convertView;

      checkBox = (CheckBox) list.findViewById(R.id.toppingCheckbox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox.isChecked()){
                    selectedTopping.add(chooseToppingList[position]);
                }
                else{
                    selectedTopping.remove(chooseToppingList[position]);
                }
            }
        });
        return list;
    }

}
