package com.example.hemil.papa_johns;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.Command.Order;
import com.example.hemil.papa_johns.Memento.Ocaretaker;
import com.example.hemil.papa_johns.Memento.Omemento;
import com.example.hemil.papa_johns.Utility.AndroidDBHelper;
import com.example.hemil.papa_johns.Utility.OrderListAdapter;
import com.example.hemil.papa_johns.state.PinEntryMachine;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemil on 11/29/2015.
 */
public class PlaceOrder extends AppCompatActivity {

    ListView listView;
    List<Omemento> lt;
    String ordername;
    double cost = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_order);
        listView = (ListView) findViewById(R.id.orderList);
        lt = new Ocaretaker().getList();
        for(int i =0;i<lt.size();i++){
            Log.d("Place Order"+i, lt.get(i).getState().getOrderName());
        }
        listView.setAdapter(new OrderListAdapter(this, lt));
    }


    public void addMoreMethod(View view){
        Intent intent = new Intent(this, MenuScreen.class);
        startActivity(intent);
    }

    public void placeOrderMethod(View view){
     //   boolean flag1 = false, flag2 = false, flag3=false, flag4 = false;

        Toast.makeText(PlaceOrder.this, "Confirm Order", Toast.LENGTH_SHORT).show();
        Button button = (Button) findViewById(R.id.placeOrderButton);
        button.setVisibility(View.GONE);
        Button button2 = (Button) findViewById(R.id.wantToEatMore);
        button2.setVisibility(View.GONE);

        final TextView textView3 = (TextView) findViewById(R.id.grandTotal);
        textView3.setVisibility(View.VISIBLE);
        for(int i=0; i< lt.size();i++){
            ordername+= lt.get(i).getState().getOrderName()+", ";
            cost+= lt.get(i).getState().getCost();
        }
        textView3.setText("Your Total : " +Math.round(cost*100.0)/100.0);

        final PinEntryMachine pinEntry = new PinEntryMachine();

        TextView t = (TextView) findViewById(R.id.promoText);
        t.setVisibility(View.VISIBLE);
       final EditText e = (EditText) findViewById(R.id.promoEditText1);
        e.setVisibility(View.VISIBLE);
        e.requestFocus();
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        imm.showSoftInput(e, InputMethodManager.SHOW_IMPLICIT);
        e.addTextChangedListener(new TextWatcher() {
            boolean flag = false;
                                     @Override
                                     public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                     }

                                     @Override
                                     public void onTextChanged(CharSequence s, int start, int before, int count) {

                                     }

                                     @Override
                                     public void afterTextChanged(Editable s) {
                                         if(e.getText().toString().matches("")){
                                        //     Log.d("Text Changed to :"+e.getText(),"&&");
                                                 pinEntry.backspace();

                                         }
                                         else{
                                          //   Log.d("Text Changed to :"+e.getText(),"**");
                                                 pinEntry.number("" + e.getText());

                                             }

                                         }

                                 });


        final EditText e2 = (EditText) findViewById(R.id.promoEditText2);
        e2.setVisibility(View.VISIBLE);
        e2.addTextChangedListener(new TextWatcher() {
            boolean flag = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(e2.getText().toString().matches("")){
           //         Log.d("Text Changed to :"+e2.getText(),"&&");
                    pinEntry.backspace();

                }
                else{
           //         Log.d("Text Changed to :"+e2.getText(),"**");
                    pinEntry.number("" + e2.getText());

                }
            }
        });

        final EditText e3 = (EditText) findViewById(R.id.promoEditText3);
        e3.setVisibility(View.VISIBLE);
        e3.addTextChangedListener(new TextWatcher() {
            boolean flag = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(e3.getText().toString().matches("")){
             //       Log.d("Text Changed to :"+e3.getText(),"&&");
                    pinEntry.backspace();

                }
                else{
            //        Log.d("Text Changed to :"+e3.getText(),"**");
                    pinEntry.number("" + e3.getText());

                }
            }
        });

        final EditText e4 = (EditText) findViewById(R.id.promoEditText4);
        e4.setVisibility(View.VISIBLE);
        e4.addTextChangedListener(new TextWatcher() {
            boolean flag = false;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if(e4.getText().toString().matches("")){
            //        Log.d("Text Changed to :"+e4.getText(),"&&");
                    pinEntry.backspace();

                }
                else{
             //       Log.d("Text Changed to :"+e4.getText(),"**");
                    pinEntry.number("" + e4.getText());

                }

                if(pinEntry.isAuthenticated()){

                    textView3.setText("Your Total : "+Math.round(cost*.8*100.0)/100.0);
                    TextView textView5 = (TextView) findViewById(R.id.promoText);
                    textView5.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    e2.setVisibility(View.GONE);
                    e3.setVisibility(View.GONE);
                    e4.setVisibility(View.GONE);
                }
            }
        });


        Button b = (Button) findViewById(R.id.confirmOrderButton);
        b.setVisibility(View.VISIBLE);

    }

    public void ConfirmOrderMethod(View view){
     //   Toast.makeText(PlaceOrder.this, "Check for Promo", Toast.LENGTH_SHORT).show();

   //     AndroidDBHelper dbHelper = new AndroidDBHelper(this);
  //      dbHelper.addOrder(ordername, cost);

 //       ArrayList<com.example.hemil.papa_johns.POJO.Order> orderList = dbHelper.getOrders();
 //       Log.d("Length",""+orderList.size());

        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}


