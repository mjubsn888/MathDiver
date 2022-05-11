package model.database;

import model.ToolAnswer;
import model.ToolArrayList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Reward {

    ToolAnswer toolAnswer;
    ArrayList<Boolean> listAnswerBool;
    int nbrCorrect=0;
    int nbrTotal=0;


    public Reward(){

        toolAnswer=new ToolAnswer();
        listAnswerBool=toolAnswer.getListAnswerBool();
        //listQuestionsAnswered=new ArrayList<>();
    }



    public void addQuestionAnswered(boolean isCorrect, String user_name, String level) throws DBException {

        listAnswerBool.add(isCorrect);
        this.nbrTotal=listAnswerBool.size();
        this.nbrCorrect=toolAnswer.calculateNbrOfCorrect();
        int rewardId=createRewardIdByNbrOfContinuousAnswers();


        updateReward(user_name, level,rewardId);
    }

    public int createRewardIdByNbrOfContinuousAnswers(){
        int rewardId=0;

        int nbrOfContinuousCorrect=ToolArrayList.getNbrOfContinuousTrueValue(listAnswerBool);

        if(nbrOfContinuousCorrect==4){
            rewardId=1;
        }
        if(nbrOfContinuousCorrect==6){
            rewardId=2;
        }
        if(nbrOfContinuousCorrect==8){
            rewardId=3;
        }
        if(nbrOfContinuousCorrect==10){
            rewardId=4;
        }
        return rewardId;
    }

    public void updateReward(String user_name, String level, int rewardId) throws DBException {

        if(rewardId!=0) {
            String field = "reward_" + Integer.toString(rewardId);

            String sql = "update reward set " + field + "=" + field + "+1 where user_name=? and level=?";
            Connection conn = DBConnection.getConn();

            //String efg="efg";
            try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                preparedStatement.setString(1, user_name);
                preparedStatement.setString(2, level);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                throw new DBException(ex);
            }
        }
    }

    public static void insertRewardForNewUser(String user_name) throws DBException {

        String sql="insert into reward (user_id,user_name,level)(select distinct a.user_id,a.user_name,b.level from user as a cross join standard as b where a.user_name=?)";

        Connection conn=DBConnection.getConn();

        try(PreparedStatement preparedStatement=conn.prepareStatement(sql))
        {
            preparedStatement.setString(1, user_name);
            preparedStatement.executeUpdate();
        }
        catch (SQLException ex) {
            throw new DBException(ex);
        }
    }

/*    public int calculateNbrOfCorrect(){
        int sum=0;
        for (Boolean b:listQuestionsAnswered) {
            if(b){
                sum+=1;
            }
        }
        return sum;
    }*/

    public int getNbrCorrect() {
        return nbrCorrect;
    }

    public int getNbrTotal() {
        return nbrTotal;
    }
}
