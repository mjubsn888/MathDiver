package model;

import java.util.ArrayList;

public class ToolAnswerMultiplication {
    ArrayList<Boolean> listAnswerBool;
    int nbrCorrect=0;
    int nbrTotal=0;

    public ToolAnswerMultiplication(){
        listAnswerBool=new ArrayList<>();
    }


    public ToolAnswerMultiplication(ArrayList<String> listAnswer, ArrayList<QuestionMultiplication> listQuestion){
        listAnswerBool=new ArrayList<>();
        buildListAnswerBool(listAnswer, listQuestion);
        this.nbrCorrect=calculateNbrOfCorrect();
        this.nbrTotal=listAnswerBool.size();
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

    public void buildListAnswerBool(ArrayList<String> listAnswer, ArrayList<QuestionMultiplication> listQuestion) {
        boolean b;
        for (int i = 0; i < listAnswer.size(); i++) {
            b = listAnswer.get(i).equals(listQuestion.get(i).getAnswerCorrect().getIdx());
            this.listAnswerBool.add(b);
        }
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
