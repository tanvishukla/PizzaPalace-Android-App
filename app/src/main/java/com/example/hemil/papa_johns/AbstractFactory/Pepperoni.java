package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class Pepperoni implements Pizza {
    double cost;

    public Pepperoni(int size, int quantity){
        if(size==1){           cost = quantity*6.99;    }
        else if(size ==2 ){    cost  = quantity*9.99;       }
        else if(size ==3){     cost = quantity* 13.99;   }
    }
    public String getName(){

        return "Ultimate Pepperoni Feast Pizza";

    }

    public double getCost()
    {

        return cost;

    }
}
