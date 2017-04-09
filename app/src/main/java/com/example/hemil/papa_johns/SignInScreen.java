package com.example.hemil.papa_johns;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.hemil.papa_johns.R;

/**
 * Created by hemil on 11/14/2015.
 */
public class SignInScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin_screen);

    }

    public void signInMethod(View view){

        Toast.makeText(SignInScreen.this, "Sign-In Request", Toast.LENGTH_SHORT).show();
        // Re-direct to the Delivery address page, but with the Welcome-Username Text
    }
}
