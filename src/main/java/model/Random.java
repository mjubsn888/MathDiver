package model;

import java.lang.Math;

public class Random {

    int max=30;
    int min=1;
    int range=max-min+1;

    Random(){}

    Random(int max, int min){
        this.max=max;
        this.min=min;
        this.range=max-min+1;//if missing, will not recalculate range
    }

    public int get1RandomInteger(){
        return (int)(Math.random()*range)+min;
    }

    public int[] get2RandomIntegers(){
        int[] arr=new int[2];

        int a=get1RandomInteger();
        int b=get1RandomInteger();

        if(a>=b){
            arr[0]=b;
            arr[1]=a;
        }
        else{
            arr[0]=a;
            arr[1]=b;
        }

        return arr;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getRange() {
        return range;
    }
}
