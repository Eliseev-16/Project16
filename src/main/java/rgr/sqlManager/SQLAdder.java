package rgr.sqlManager;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLAdder.
 */
public class SQLAdder {
    
    /**
     * Adds the user.
     *
     * @param login the login
     * @param password the password
     * @param access the access
     * @throws Exception the exception
     */
    public static void addUser(String login, String password, String access) throws Exception {
        String mask = "[A-Za-z0-9]";

        Pattern pt = Pattern.compile(mask);
        for (int i = 0; i < login.length(); i++) {
            Matcher matcher = pt.matcher(Character.toString(login.charAt(i)));
            if (!matcher.matches()) throw new Exception("Only numbers or English characters are allowed");
        }
        for (int i = 0; i < password.length(); i++) {
            Matcher matcher = pt.matcher(Character.toString(password.charAt(i)));
            if (!matcher.matches()) throw new Exception("Only numbers or English characters are allowed");
        }


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

    /**
     * Adds the coefficients.
     *
     * @param income the income
     * @param incomeNonResident the income non resident
     * @param pension the pension
     * @param medical the medical
     * @param social the social
     * @param insurance the insurance
     * @throws Exception the exception
     */
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
