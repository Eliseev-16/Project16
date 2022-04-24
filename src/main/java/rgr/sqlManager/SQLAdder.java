package rgr.sqlManager;

import java.sql.SQLException;
import java.sql.Statement;

public class SQLAdder {
    public static void addUser(String login, String password, String access){
        SQLConnection conn = new SQLConnection();
        Statement st = conn.getStatement();
        try {
            st.execute("INSERT INTO 'Users' ('Login','Password','Access') VALUES ('"+login+"','"+password+"','"+access+"')");
            conn.closeConnection();
        } catch (SQLException e){
            System.out.println("Ошибка добавления");
        }
    }
}
