package rgr.sqlManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLReader {
    public static int readUser(String login, String password){
        int access = 0;
        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Users WHERE Login='" +login +"'LIMIT 1;");
            if (res.getString("Password").equals(password)) {
                access = res.getInt("Access");
                conn.closeConnection(res);
            } else throw new SQLException("Неверно введен пароль");
        } catch (SQLException e){
            System.out.println("Ошибка логина или пароля");
        }

        return access;
    }
}
