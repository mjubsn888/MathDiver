package model;

import java.util.*;

public class AnswersMatch {

    Set<Integer> indicesSet;
    ArrayList<Integer> indicesList;

    public AnswersMatch(){
        indicesSet=new HashSet<>();
        indicesList=new ArrayList<>();

        Random rdm=new Random(4, 1);

        while (indicesSet.size()<4) {
            indicesSet.add(rdm.get1RandomInteger());
        }

        indicesList.addAll(indicesSet);
    }

    public void MatchAnswers(ArrayList<Answer> answersNotMatched){
        for (int i = 0; i < indicesList.size(); i++) {
            int t=indicesList.get(i);
            answersNotMatched.get(i).setIdxAndId(t);        }
    }
}
