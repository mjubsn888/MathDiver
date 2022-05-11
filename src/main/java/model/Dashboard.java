package model;

import model.database.DBException;

import java.util.ArrayList;

public class Dashboard {

    String username;
    ArrayList<DashboardItem> listDashboardItems;
    DashboardItem dashboard;
    String level;

    public Dashboard(String username, String level, String activity, String test_id_1, String test_id_2) throws DBException {
        this.username=username;
        listDashboardItems=new ArrayList<>();
        this.level=level;
        listDashboardItems.add(new DashboardItem(username,activity, test_id_1));
        listDashboardItems.add(new DashboardItem(username,activity, test_id_2));
        //listDashboardItems.add(new DashboardItem(username,activity, test_id_3));
    }

    public ArrayList<DashboardItem> getListDashboardItems() {
        return listDashboardItems;
    }

}
