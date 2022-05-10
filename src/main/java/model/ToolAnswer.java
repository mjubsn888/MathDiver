package model;

import java.util.ArrayList;

public class ToolAnswer {
    ArrayList<Boolean> listAnswerBool;
    int nbrCorrect=0;
    int nbrTotal=0;

    public ToolAnswer(){
        listAnswerBool=new ArrayList<>();
    }    

    public int calculateNbrOfCorrect(){
        int sum=0;
        for (Boolean b:listAnswerBool) {
            if(b){
                sum+=1;
            }
        }
        return sum;
    }

    public int getNbrCorrect() {
        return nbrCorrect;
    }

    public int getNbrTotal() {
        return nbrTotal;
    }

    public ArrayList<Boolean> getListAnswerBool() {
        return listAnswerBool;
    }

    public void setNbrTotal(int nbrTotal) {
        this.nbrTotal = nbrTotal;
    }

    public void setListAnswerBool(ArrayList<Boolean> listAnswerBool) {
        this.listAnswerBool = listAnswerBool;
    }
}
