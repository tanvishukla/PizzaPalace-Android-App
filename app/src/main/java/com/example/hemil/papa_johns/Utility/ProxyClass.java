package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.os.AsyncTask;

import com.example.hemil.papa_johns.CreateAccount;

/**
 * Created by hemil on 12/5/2015.
 */
public class ProxyClass implements SubjectProxy {

    String  name, email, pass, phone;

    public ProxyClass(){

    }

    public void writeData(Context context,String name, String email, String pass, String phone){
       AsyncTaskRunner runner = new AsyncTaskRunner(context);
        runner.execute(name,email,pass,phone);

    }



    @Override
    public void readData(String email) {

    }

}
