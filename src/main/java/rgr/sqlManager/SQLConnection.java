package rgr.sqlManager;

import javax.swing.*;
import java.sql.*;

public class SQLConnection {

    //String login = "root";
    //String pass = "";//?useSSL=false
    String url = "jdbc:sqlite:Users.s3db";
    private Connection connection;
    private Statement statement;
    private boolean isConnect = false;

    public SQLConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            System.out.println("Ошибка создания драйвера");
        }
        connect();
    }

    private void connect(){
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            isConnect = true;
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к БД");
        }
    }

    public Connection getConnection() {
        try {
            if (isConnect) return connection;
        } catch (Exception e){
            System.out.println("Сначала нужно соедениться с БД");
        }
        return null;
    }

    public Statement getStatement() {
        try {
            if (isConnect) return statement;
        } catch (Exception e){
            System.out.println("Сначала нужно соедениться с БД");
        }
        return null;
    }

    public void closeConnection(){
        try {
            connection.close();
            statement.close();
        } catch (SQLException e){
            System.out.println("Сначала нужно соедениться с БД");
        }

    }

    public void closeConnection(ResultSet r){
        try {
            connection.close();
            statement.close();
            r.close();
        } catch (SQLException e){
            System.out.println("Сначала нужно соедениться с БД");
        }
    }

    public static void main(String[] args) {
        SQLConnection a = new SQLConnection();
    }
}
