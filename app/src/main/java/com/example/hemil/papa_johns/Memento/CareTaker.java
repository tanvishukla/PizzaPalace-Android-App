package com.example.hemil.papa_johns.Memento;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemil on 11/24/2015.
 */
public class CareTaker {

    private static List<Memento> list = new ArrayList<Memento>();

    public List<Memento> getList(){
        return list;
    }
    public void add(Memento memento){
        list.add(memento);
        Log.d("added",memento.getState().toString());
    }

    public Memento get(int index){
        return list.get(index);
    }



}

