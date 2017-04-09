package com.example.hemil.papa_johns.POJO;

/**
 * Created by hemil on 11/29/2015.
 */
public class Order {
    String orderName;
    double cost;

    public Order(){}

    public Order(String orderName, double cost){
        this.orderName = orderName;
        this.cost = cost;
    }

    public String getOrderName() {
        return orderName;
    }
    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

}
