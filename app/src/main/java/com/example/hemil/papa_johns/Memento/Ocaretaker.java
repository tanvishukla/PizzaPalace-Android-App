package com.example.hemil.papa_johns.Memento;

import android.util.Log;

import com.example.hemil.papa_johns.Command.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hemil on 11/29/2015.
 */
public class Ocaretaker  implements Order{

    private static List<Omemento> list = new ArrayList<Omemento>();

    public List<Omemento> getList(){
        return list;
    }
    public void add(Omemento omemento){
        list.add(omemento);
        Log.d("added", omemento.getState().toString());
    }

    public Omemento get(int index){
        return list.get(index);
    }

    @Override
    public void addToDB() {

    }
}
