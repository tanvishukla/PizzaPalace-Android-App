package com.example.hemil.papa_johns;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hemil.papa_johns.R;
import com.example.hemil.papa_johns.Utility.ProxyClass;
import com.example.hemil.papa_johns.Utility.SubjectProxy;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by hemil on 11/14/2015.
 */
public class CreateAccount extends AppCompatActivity {

    Thread t;
    EditText name,email,password,phone;
    String acc_name, acc_email, acc_pass, acc_phone;
    boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);
        name = (EditText) findViewById(R.id.createAccountNameEdit);
        email = (EditText) findViewById(R.id.createAccountEmailEdit);
        password = (EditText) findViewById(R.id.createAccountPasswordEdit);
        phone = (EditText) findViewById(R.id.createAccountPhoneEdit);

    }

    public void createAccountMethod(View view){
        acc_name = name.getText().toString();
        acc_email = email.getText().toString();
        acc_pass = password.getText().toString();
        acc_phone = phone.getText().toString();

        if(!(acc_name.isEmpty() && acc_email.isEmpty() && acc_pass.isEmpty() && acc_phone.isEmpty()) &&
                validateEmail(acc_email)) {
      //      AsyncTaskRunner runner = new AsyncTaskRunner();
     //       runner.execute();

            SubjectProxy proxy = new ProxyClass();
            proxy.writeData(this,acc_name,acc_email,acc_pass,acc_phone);
        }
        else
        {   TextView errorView = (TextView) findViewById(R.id.errorText);
            errorView.setVisibility(View.VISIBLE);
            flag=true;
        }
    }

    private boolean validateEmail(String email){
         final Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(email);
        return matcher.find();
    }

  /*  protected class AsyncTaskRunner extends AsyncTask<String,Void,String>{

        private String response;

        @Override
        protected String doInBackground(String...params){
            //   publishProgress("Sleeping...");
            try{
                URL url = new URL("http://10.0.0.113:8080/202_Project_Server/webapi/dominos/registerUser");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("content-type","application/x-www-form-urlencoded");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                Uri.Builder builder = new Uri.Builder()
                        .appendQueryParameter("Name",acc_name)
                        .appendQueryParameter("Email",acc_email)
                        .appendQueryParameter("Password",acc_pass)
                        .appendQueryParameter("PhoneNum",acc_phone)
                        ;
                String query = builder.build().getEncodedQuery();
                Log.d("Query",query);
                OutputStream os = conn.getOutputStream();
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                bw.write(query);
                bw.flush();
                bw.close();
                conn.connect();
                int responsecode = conn.getResponseCode();
                Log.d("Response Code",""+responsecode);
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while((line=br.readLine())!=null){
                    response+= line;
                }
            }
            catch(Exception e ){
                e.printStackTrace();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("com.Dominos.User_Key", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("User_Name", acc_name);
            edit.putBoolean("LoggedIn", true);
            edit.commit();
            //      Log.d("SharedPrefferenced", "Done");

            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
            intent.putExtra("UserName",acc_name);
            startActivity(intent);
            CreateAccount.this.finish();
        }
    }
    */
}
