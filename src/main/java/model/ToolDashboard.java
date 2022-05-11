package model;

import model.database.DBException;

import java.util.ArrayList;

public class ToolDashboard {

    String username;
    ArrayList<Dashboard> listDashboard;
    Dashboard dashboard;

    public ToolDashboard(String username) throws DBException {
        listDashboard=new ArrayList<>();

        listDashboard.add(new Dashboard(username, "k1", "practice", "1a", "1s"));
        listDashboard.add(new Dashboard(username, "k1", "test", "1a", "1s"));       

    }

    public ArrayList<Dashboard> getListDashboard() {
        return listDashboard;
    }
    
}
