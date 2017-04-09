package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class Memphis_BBQ implements Pizza {
    double cost;

    public Memphis_BBQ(int size, int quantity){
        if(size==1){           cost = quantity*9.99;    }
        else if(size ==2 ){    cost  = quantity*13.50;       }
        else if(size ==3){     cost = quantity* 16.50;   }
    }
    public String getName(){

        return "Memphis BBQ Chicken Pizza";

    }

    public double getCost()
    {

        return cost;

    }
}
