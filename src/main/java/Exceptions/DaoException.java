package Exceptions;
import java.sql.SQLException;
public class DaoException extends SQLException{
    public DaoException(){

    }
    public DaoException(String aMessage){
        super(aMessage);
    }
}

//this will make our error more readable, easier to debug and just makes it clear to us that the error comes form the DAO layer