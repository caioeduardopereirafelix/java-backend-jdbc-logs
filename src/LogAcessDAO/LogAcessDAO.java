package LogAcessDAO;

import Factory.ConnectionFactory;
import Model.LogAcess;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;


public class LogAcessDAO{

    List<LogAcess> logAcessList = new ArrayList<>();

    public void registerLog(LogAcess logUser) throws SQLException {

        try(Connection connection = new ConnectionFactory().getConnection()){

            String sql = "INSERT INTO LOG_ACESS (usuario, acao, data_hora, ip) VALUES(?,?,?,?)";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, logUser.getUser());
                preparedStatement.setString(2, logUser.getAction());
                preparedStatement.setTimestamp(3, Timestamp.valueOf(logUser.getDateTime()));
                preparedStatement.setString(4, logUser.getIp());
                preparedStatement.executeUpdate();
                try(ResultSet rst = preparedStatement.getGeneratedKeys()){
                    while (rst.next()){
                        logUser.setId(rst.getInt(1));
                    }
                }

            }

        }catch (SQLException e){
            throw new RuntimeException("Erro ao registrar log: " + e);
        }

    }

    public void deleteForId(int id) throws SQLException {
        try (Connection connection = new ConnectionFactory().getConnection()) {

            String sql = "DELETE FROM LOG_ACESS WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
                System.out.println("Exclusao bem sucedida");

            }catch (SQLException e){
                throw new RuntimeException("Erro ao deletar Log: " + e);
            }
        }
    }

    public void logAcessListFunction() throws SQLException {
        try(Connection connection = new ConnectionFactory().getConnection()) {
            String sql = "SELECT * FROM LOG_ACESS";

            try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.execute();

                try(ResultSet rs = preparedStatement.getResultSet()) {
                    while (rs.next()) {
                        Integer id = rs.getInt("id");
                        String name = rs.getString("usuario");
                        String action = rs.getString("acao");
                        LocalDateTime localDateTime = rs.getTimestamp("data_hora").toLocalDateTime();
                        String ip = rs.getString("ip");
                        System.out.println("Id: " + id +
                                            " Name: " + name +
                                            " Action: " + action +
                                            " Date: " + localDateTime +
                                            " Ip: " + ip);

                    }
                }
            }

        }

    }

}
