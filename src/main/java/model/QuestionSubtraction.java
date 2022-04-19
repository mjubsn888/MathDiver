package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class QuestionSubtraction {

    ArrayList<Integer> listParams; //numbers (parameters) used in question, such as 8-5=?
    ArrayList<String> listParamsStr;

    Set<Integer> setAnswersContent;
    ArrayList<Answer> listAnswers;
    Answer answerCorrect;

    int max=30;
    int min=1;

    public QuestionSubtraction() {

        setAnswersContent=new HashSet<>();
        listParamsStr=new ArrayList<>();
        listAnswers=new ArrayList<>();

        //1.generate question
        this.listParams = Random.get2RandomIntegers(max, min);

        for (int i = 0; i < listParams.size(); i++) {
            listParamsStr.add(Integer.toString(listParams.get(i)));
        }
        int result = listParams.get(1) - listParams.get(0);  //f=a-b

        //2.generate answers: correct answer
        setAnswersContent.add(result);
        while (setAnswersContent.size() < 4) {
            int r= Random.get1RandomInteger(max, min);
            setAnswersContent.add(r);
        }

        for (Integer content:setAnswersContent) {
            listAnswers.add(new Answer(content));
        }

        //3.set the correct answer
        for (Answer answer:listAnswers) {
            if(answer.getContent()==result){
                answer.setIsCorrect(true);
                answerCorrect=answer;
            }
        }
        //4. set answers id
        AnswersSetId answersSetId=new AnswersSetId();
        answersSetId.setAnswersId(listAnswers);
    }

    public Answer getAnswerCorrect() {
        return answerCorrect;
    }

    public ArrayList<String> getListParamsStr() {
        return listParamsStr;
    }
    public ArrayList<Answer> getListAnswers() {
        return listAnswers;
    }
}



