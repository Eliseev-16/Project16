package rgr.sqlManager;

import java.sql.SQLException;
import java.sql.Statement;

public class SQLAdder {
    public static void addUser(String login, String password, String access) throws Exception {

        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            st.execute("INSERT INTO 'Users' ('Login','Password','Access') VALUES ('"+login+"','"+password+"','"+access+"')");
            conn.closeConnection();
        } catch (SQLException e){
            throw new Exception("Error adding a user");
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public static void addCoefficients(String income,String incomeNonResident, String pension,
                                       String medical, String social, String insurance) throws Exception {

        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            st.execute("INSERT INTO 'Coefficients' ('income','incomeNonResident','pension','medical','social','insurance') " +
                    "VALUES ('"+income+"','"+incomeNonResident+"','"+pension+"','"+medical+"','"+social+"','"+insurance+"')");
            conn.closeConnection();
        } catch (SQLException e){
            throw new Exception("Error adding a coefficients");
        }
        catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

    }


}
