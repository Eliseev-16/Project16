package rgr.sqlManager;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Locale;

public class SQLConnection {

    //String login = "root";
    //String pass = "";//?useSSL=false
    public String url;
    private Connection connection;
    private Statement statement;
    private boolean isConnect = false;

    public SQLConnection() throws Exception {
        URL basePathS = this.getClass ().getResource("");
        String basePath = basePathS.getPath();
        if (basePath.toLowerCase().contains("classes")){
        basePath = basePath.substring(0,basePath.indexOf("classes") + 7) + "/";
        url = "jdbc:sqlite:" + basePath + "Users.s3db";}
        else url = "jdbc:sqlite:" + basePath + "/"+ "Users.s3db";
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception ex) {
            throw new Exception("Driver creation error");
        }
        connect();
    }

    private void connect() throws Exception {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            isConnect = true;
        } catch (SQLException e) {
            throw new Exception("DB connection error");
        }
    }

    public Connection getConnection() throws Exception {
        try {
            if (isConnect) return connection;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }

    public Statement getStatement() throws Exception {
        try {
            if (isConnect) return statement;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }

    public void closeConnection() throws Exception {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }

    }

    public void closeConnection(ResultSet r) throws Exception {
        try {
            connection.close();
            statement.close();
            r.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }
    }

    public static void main(String[] args) throws Exception {
//        //SQLConnection a = new SQLConnection();
//        String basePath = new File("").getAbsolutePath();
//        String url;
//        basePath = "/home/eliseev/apache-tomcat-9.0.62/webapps/Calculate/WEB-INF/classes/fsefsfsef";
//        if (basePath.toLowerCase().contains("classes")){
//            basePath = basePath.substring(0,basePath.indexOf("classes") + 7) + "/";
//            url = "jdbc:sqlite:" + basePath + "Users.s3db";}
//        else url = "jdbc:sqlite:" + basePath + "/"+ "Users.s3db";
//        System.out.println(basePath);
        //SQLAdder.addCoefficients("13","30","22","5.1","2.9","0.2");
        //SQLAdder.addUser("user","user","1");
        //SQLAdder.addUser("admin","admin","2");
        //SQLAdder.addUser("Eliseev","12345","1");
        //System.out.println(SQLReader.readCoefficients().toString());


    }
}
