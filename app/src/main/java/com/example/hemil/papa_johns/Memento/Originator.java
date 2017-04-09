package com.example.hemil.papa_johns.Memento;

import com.example.hemil.papa_johns.POJO.Address;

/**
 * Created by hemil on 11/24/2015.
 */
public class Originator {
    private Address address;

    public void setState(Address address){
        this.address = address;
    }

    public Address getState(){
        return address;
    }

    public void getStateFromMemento(Memento memento){
        address = memento.getState();
    }

    public Memento saveStateToMemento(){
        return new Memento(address);
    }
}
