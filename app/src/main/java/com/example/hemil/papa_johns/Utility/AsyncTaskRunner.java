package com.example.hemil.papa_johns.Utility;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import com.example.hemil.papa_johns.CreateAccount;
import com.example.hemil.papa_johns.MainActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by hemil on 12/5/2015.
 */
public class AsyncTaskRunner extends AsyncTask<String,Void,String> {

    private String response;
    private Context context;
    private String acc_name;
    public AsyncTaskRunner(Context context){
            this.context = context;
    }

    @Override
    protected String doInBackground(String...params){
        //   publishProgress("Sleeping...");
        acc_name = params[0];
        try{
            URL url = new URL("http://10.189.38.1:8080/202_Project_Server/webapi/dominos/registerUser");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("content-type","application/x-www-form-urlencoded");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            Uri.Builder builder = new Uri.Builder()
                    .appendQueryParameter("Name",params[0])
                    .appendQueryParameter("Email",params[1])
                    .appendQueryParameter("Password",params[2])
                    .appendQueryParameter("PhoneNum",params[3])
                    ;
            String query = builder.build().getEncodedQuery();
            Log.d("Query", query);
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
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences("com.Dominos.User_Key", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("User_Name",acc_name);
        edit.putBoolean("LoggedIn", true);
        edit.commit();
        //      Log.d("SharedPrefferenced", "Done");

        Intent intent = new Intent(context.getApplicationContext(),MainActivity.class);
        intent.putExtra("UserName", acc_name);
        context.startActivity(intent);

    }
}
