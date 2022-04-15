package model;

import java.util.*;

public class AnswersSetId {
    Set<Integer> indicesSet;
    ArrayList<Integer> indicesList;
    int max=4;
    int min=1;

    public AnswersSetId(){
        indicesSet=new HashSet<>();
        indicesList=new ArrayList<>();

        while (indicesSet.size()<4) {
            indicesSet.add(Random.get1RandomInteger(4,1));
        }
        indicesList.addAll(indicesSet);
    }

    public void setAnswersId(ArrayList<Answer> answersNoId){
        for (int i = 0; i < indicesList.size(); i++) {
            int t=indicesList.get(i);
            answersNoId.get(i).setIdx(t);        }
    }
}
