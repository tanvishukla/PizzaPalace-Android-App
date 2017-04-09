package com.example.hemil.papa_johns.Memento;

import com.example.hemil.papa_johns.POJO.Address;

/**
 * Created by hemil on 11/24/2015.
 */
public class Memento {
    Address address;

    public Memento(Address address){
        this.address = address;
    }

    public Address getState(){
        return address;
    }

}

