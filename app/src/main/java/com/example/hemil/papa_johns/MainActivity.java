package com.example.hemil.papa_johns;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView welcomeText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = getSharedPreferences("com.Dominos.User_Key", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_main);
       if(getSharedPreferences("com.Dominos.User_Key", 0).getBoolean("LoggedIn", false)){
            welcomeText = (TextView) findViewById(R.id.welcomeText);
            welcomeText.setText("Welcomes you,"+getSharedPreferences("com.Dominos.User_Key", 0).getString("User_Name", null));
           button = (Button) findViewById(R.id.signUpQuestion);
            button.setVisibility(View.INVISIBLE);
        }
    }

    public void deliveryOption(View view){
        Intent intent = new Intent(getApplicationContext(),DeliveryAddress.class);
        startActivity(intent);
    }

    public void carryoutOption(View view){
        Toast.makeText(MainActivity.this, "Carryout", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,Carryout_One.class);
        startActivity(intent);

    }

    public void createAccount(View view){
        Intent intent = new Intent(this,CreateAccount.class);
        startActivity(intent);
        MainActivity.this.finish();
    }
}
