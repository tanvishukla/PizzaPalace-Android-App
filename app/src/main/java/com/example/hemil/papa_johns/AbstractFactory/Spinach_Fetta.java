package com.example.hemil.papa_johns.AbstractFactory;

/**
 * Created by hemil on 11/28/2015.
 */
public class Spinach_Fetta implements Pizza{

     double cost;

    public Spinach_Fetta(int size, int quantity){
        if(size==1){           cost = quantity*10.49;    }
        else if(size ==2 ){    cost  = quantity*13.49;       }
        else if(size ==3){     cost = quantity* 17.99;   }
    }
    public String getName(){

        return "Spinach & Fetta Pizza";

    }

    public double getCost()
    {

        return cost;

    }
}
