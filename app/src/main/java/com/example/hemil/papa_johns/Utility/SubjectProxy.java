package com.example.hemil.papa_johns.Utility;

import android.content.Context;

/**
 * Created by hemil on 12/5/2015.
 */
public interface SubjectProxy {

    public void writeData(Context context,String name, String email, String pass, String phone);
    public void readData(String email);
}
