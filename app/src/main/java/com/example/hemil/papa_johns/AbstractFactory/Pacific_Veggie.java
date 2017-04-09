package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class Pacific_Veggie implements Pizza {

    double cost;

    public Pacific_Veggie(int size, int quantity){
        if(size==1){           cost = quantity*8.99;    }
        else if(size ==2 ){    cost  = quantity*11.99;       }
        else if(size ==3){     cost = quantity* 14.50;}
    }

    public String getName(){

        return "Pacific Veggie Pizza";

    }

    public double getCost()
    {

        return cost;

    }
}
