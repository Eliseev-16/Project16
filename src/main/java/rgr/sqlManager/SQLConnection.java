package rgr.sqlManager;

import javax.swing.*;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.Locale;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLConnection.
 */
public class SQLConnection {

    //String login = "root";
    /** The url. */
    //String pass = "";//?useSSL=false
    public String url;
    
    /** The connection. */
    private Connection connection;
    
    /** The statement. */
    private Statement statement;
    
    /** The is connect. */
    private boolean isConnect = false;

    /**
     * Instantiates a new SQL connection.
     *
     * @throws Exception the exception
     */
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

    /**
     * Connect.
     *
     * @throws Exception the exception
     */
    private void connect() throws Exception {
        try {
            connection = DriverManager.getConnection(url);
            statement = connection.createStatement();
            isConnect = true;
        } catch (SQLException e) {
            throw new Exception("DB connection error");
        }
    }

    /**
     * Gets the connection.
     *
     * @return the connection
     * @throws Exception the exception
     */
    public Connection getConnection() throws Exception {
        try {
            if (isConnect) return connection;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }

    /**
     * Gets the statement.
     *
     * @return the statement
     * @throws Exception the exception
     */
    public Statement getStatement() throws Exception {
        try {
            if (isConnect) return statement;
        } catch (Exception e){
            throw new Exception("First you need to connect to the database");
        }
        return null;
    }

    /**
     * Close connection.
     *
     * @throws Exception the exception
     */
    public void closeConnection() throws Exception {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }

    }

    /**
     * Close connection.
     *
     * @param r the r
     * @throws Exception the exception
     */
    public void closeConnection(ResultSet r) throws Exception {
        try {
            connection.close();
            statement.close();
            r.close();
        } catch (SQLException e){
            throw new Exception("First you need to connect to the database");
        }
    }

    /**
     * The main method.
     *
     * @param args the arguments
     * @throws Exception the exception
     */
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
