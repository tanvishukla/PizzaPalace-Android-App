package com.example.hemil.papa_johns;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.hemil.papa_johns.Memento.CareTaker;
import com.example.hemil.papa_johns.Memento.Memento;
import com.example.hemil.papa_johns.Memento.Originator;
import com.example.hemil.papa_johns.POJO.Address;
import com.example.hemil.papa_johns.R;

/**
 * Created by hemil on 11/14/2015.
 */
public class DeliveryAddress extends AppCompatActivity {

    EditText streetName,aptName,cityname,stateName,zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.delivery_address);

        if(getSharedPreferences("com.Dominos.User_Key", 0).getBoolean("LoggedIn", false)){
            RelativeLayout rel = (RelativeLayout) findViewById(R.id.belowTopPanel);
            rel.setVisibility(View.GONE);
        }
        streetName = (EditText) findViewById(R.id.streetNameText);
        aptName = (EditText) findViewById(R.id.aptNumText);
        cityname = (EditText) findViewById(R.id.cityText);
        stateName = (EditText) findViewById(R.id.stateText);
        zipCode = (EditText) findViewById(R.id.zipCodeText);

    }

    public void signInMethod(View view){
        Toast.makeText(getApplicationContext(),"Sign-In",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),SignInScreen.class);
        startActivity(intent);
    }

    public void continueDelivery(View view){

        String str = streetName.getText()+", "+aptName.getText()+", "+cityname.getText()+", "+stateName.getText()+", "+zipCode.getText();
        Toast.makeText(getApplicationContext(),"Continue Delivery",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),MenuScreen.class);
        intent.putExtra("Type","Delivery");
        intent.putExtra("Address",str);
        startActivity(intent);
        this.finish();
    }

    public void saveAddressMethod(View view){
        if(((CheckBox)(findViewById(R.id.saveAddress))).isChecked()) {
            Address address = new Address();
            address.setStreetName(streetName.getText().toString());
            address.setAptNum(aptName.getText().toString());
            address.setCity(cityname.getText().toString());
            address.setState(stateName.getText().toString());
            address.setZipCode(zipCode.getText().toString());

            Originator originator = new Originator();
            originator.setState(address);

            CareTaker careTaker = new CareTaker();
            careTaker.add(originator.saveStateToMemento());
        }
    }
    public void showFaviouriteMethod(View view) {
        if (((CheckBox) findViewById(R.id.showFaviourites)).isChecked()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Choose Address");

            final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_singlechoice);

           final CareTaker careTaker = new CareTaker();
            for (int i = 0; i < careTaker.getList().size(); i++) {
                arrayAdapter.add("" + careTaker.get(i).getState().getAptNum()+", "+careTaker.get(i).getState().getStreetName()+", "+
                        careTaker.get(i).getState().getCity()+", "+careTaker.get(i).getState().getState()+", "+
                        careTaker.get(i).getState().getZipCode());
            }

            builder.setNegativeButton("cancel",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            dialogInterface.dismiss();
                        }
                    }
            );

            builder.setAdapter(arrayAdapter,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            String str = arrayAdapter.getItem(which);
                            AlertDialog.Builder builderInner = new AlertDialog.Builder(DeliveryAddress.this);
                            builderInner.setMessage(str);
                            builderInner.setTitle("Your selected Item is :");
                            final AlertDialog.Builder builder1 = builderInner.setPositiveButton(
                                    "Ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            streetName.setText(careTaker.get(which+1).getState().getStreetName());
                                            aptName.setText(careTaker.get(which+1).getState().getAptNum());
                                            cityname.setText(careTaker.get(which+1).getState().getCity());
                                            stateName.setText(careTaker.get(which+1).getState().getState());
                                            zipCode.setText(careTaker.get(which+1).getState().getZipCode());
                                            dialog.dismiss();
                                        }
                                    }
                            );

                            builderInner.show();
                        }
                    });
            builder.show();

        }
    }
}
