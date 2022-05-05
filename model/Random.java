package model;

import java.lang.Math;
import java.util.ArrayList;

public class Random {

    //int max=30;
    //int min=1;
    //int range=max-min+1;

    Random(){}

    public static int get1RandomInteger(int max, int min){

        int range=max-min+1;

        return (int)(Math.random()*range)+min;
    }

    public static ArrayList<Integer> get2RandomIntegers(int max, int min){ //sorted, in ascending order
        ArrayList<Integer> list=new ArrayList<>();
        int a=get1RandomInteger(max, min);
        int b=get1RandomInteger(max, min);

        if(a>=b){
            list.add(b);
            list.add(a);
        }
        else{
            list.add(a);
            list.add(b);
        }
        return list;
    }

}
