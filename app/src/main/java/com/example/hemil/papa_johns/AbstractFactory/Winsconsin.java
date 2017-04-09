package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class Winsconsin implements Pizza {
    double cost;

    public Winsconsin(int size, int quantity){
        if(size==1){           cost = quantity*9.49;    }
        else if(size ==2 ){    cost  = quantity*12.99;       }
        else if(size ==3){     cost = quantity* 14.49;   }
    }
    public String getName(){

        return "Winsconsin 6 Cheeze Pizza";

    }

    public double getCost()
    {

        return cost;

    }
}
