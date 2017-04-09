package com.example.hemil.papa_johns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.Utility.PlaceListAdapter;

/**
 * Created by hemil on 12/4/2015.
 */
public class Carryout_One extends AppCompatActivity {

    ListView listView;
    String places[] = {"STORE #7984\n" +
            "907 Del Mar Ave\n" +
            "San Jose, CA 95128\n" +
            "Behind 711.","STORE #7994\n" +
            "576 E Santa Clara St\n" +
            "San Jose, CA 95112\n" +
            "Next to NEXT TO KFC.","STORE #8290\n" +
            "1710 Berryessa Rd. Suite #102\n" +
            "San Jose, CA 95133","STORE #8581\n" +
            "2682 Union Avenue\n" +
            "San Jose, CA 95124","STORE #7932\n" +
            "3207 Cabrillo Avenue\n" +
            "Santa Clara, CA"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carryout_one);
         listView = (ListView) findViewById(R.id.placeListView);
         listView.setAdapter(new PlaceListAdapter(this,places));
         listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      //          Toast.makeText(Carryout_One.this, ""+places[position], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MenuScreen.class);
                intent.putExtra("Type","Carry-Out");
                intent.putExtra("Address", places[position]);
                startActivity(intent);
                Carryout_One.this.finish();


            }
        });
    }
}
