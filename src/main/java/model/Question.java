package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Question {

    int correct;
    String txtCorrect;
    int[] params; //numbers (parameters) used in question

    Answer answerCorrect;
    Set<Answer> answersWIP;
    ArrayList<Answer> answers;

    public Question() {
        //1.generate question
        Random rdm = new Random();
        this.params = rdm.get2RandomIntegers();
        int result = params[1] - params[0];  //f=a-b

        //2.generate answers
        answersWIP = new HashSet<Answer>();
        answerCorrect = new Answer(result, true);
        answersWIP.add(answerCorrect);
        int count = 1;
        while (answersWIP.size() < 4) {
            answersWIP.add(new Answer(rdm.get1RandomInteger(), false));
        }

        answers=new ArrayList<>();
        answers.addAll(answersWIP);

        AnswersMatch answersMatch=new AnswersMatch();
        answersMatch.MatchAnswers(answers);
    }

    public int[] getParams() {
        return params;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }
}



