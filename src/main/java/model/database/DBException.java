package model.database;

public class DBException extends Exception{

    public DBException(){}

    public DBException(Exception ex){
        super(ex);
    }
}
