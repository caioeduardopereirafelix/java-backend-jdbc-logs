package Model;

import Factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LogAcess  {
    private Integer id;
    private String user;
    private String action;
    private LocalDateTime  dateTime;
    private String ip;

    public LogAcess(String user, String action, LocalDateTime dateTime, String ip) throws SQLException {
        this.user = user;
        this.action = action;
        this.dateTime = dateTime;
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getIp() {
        return ip;
    }

    public void setId(Integer id) {
        this.id = id;
    }



}
