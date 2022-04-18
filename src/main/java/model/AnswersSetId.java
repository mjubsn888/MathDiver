package model;

import java.util.*;

public class AnswersSetId {
    Set<Integer> setIndices;
    ArrayList<Integer> listIndices;
    int max=4;
    int min=1;

    public AnswersSetId(){
        setIndices =new HashSet<>();
        listIndices =new ArrayList<>();

        while (setIndices.size()<4) {
            setIndices.add(Random.get1RandomInteger(4,1));
        }
        listIndices.addAll(setIndices);
    }

    public void setAnswersId(ArrayList<Answer> answersNoId){
        for (int i = 0; i < listIndices.size(); i++) {
            int t= listIndices.get(i);
            answersNoId.get(i).setIdx(MapDiffVarTyp.mapIntegerToString(t));
        }
    }
}
