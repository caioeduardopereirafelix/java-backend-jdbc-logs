package Main;

import Factory.ConnectionFactory;
import LogAcessDAO.LogAcessDAO;
import Model.LogAcess;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws SQLException {

        LogAcess logAcess1 = new LogAcess("Caio", "Acess", LocalDateTime.now(), "192.168.0.1");
        LogAcessDAO logAcessDAO = new LogAcessDAO();
        //logAcessDAO.registerLog(logAcess1);
        logAcessDAO.logAcessListFunction();




    }
}
