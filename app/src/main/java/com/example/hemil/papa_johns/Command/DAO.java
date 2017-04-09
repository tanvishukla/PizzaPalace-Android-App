package com.example.hemil.papa_johns.Command;

import com.example.hemil.papa_johns.POJO.*;

/**
 * Created by hemil on 12/4/2015.
 */
public class DAO implements Order {

    Order order;

    public DAO(Order order){
        this.order = order;
    }

    @Override
    public void addToDB() {
            order.addToDB();
    }
}
