package com.example.hemil.papa_johns.Memento;

import com.example.hemil.papa_johns.POJO.Address;
import com.example.hemil.papa_johns.POJO.Order;

/**
 * Created by hemil on 11/29/2015.
 */
public class Ooriginator {

    private Order order;

    public void setState(Order order){
        this.order = order;
    }

    public Order getState(){
        return order;
    }

    public void getStateFromMemento(Omemento omemento){
        order = omemento.getState();
    }

    public Omemento saveStateToMemento(){
        return new Omemento(order);
    }
}
