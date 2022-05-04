package rgr.sqlManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class SQLReader.
 */
public class SQLReader {
    
    /**
     * Read user.
     *
     * @param login the login
     * @param password the password
     * @return the int
     * @throws Exception the exception
     */
    public static int readUser(String login, String password) throws Exception {
        int access = 0;
        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Users WHERE Login='" +login +"'LIMIT 1;");
            if (res.getString("Password").equals(password)) {
                access = res.getInt("Access");
                conn.closeConnection(res);
            } else access = 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return access;
    }

    /**
     * Read coefficients.
     *
     * @return the coefficient values
     * @throws Exception the exception
     */
    public static CoefficientValues readCoefficients() throws Exception {
        CoefficientValues cv = null;
        try {
            SQLConnection conn = new SQLConnection();
            Statement st = conn.getStatement();
            ResultSet res = st.executeQuery("SELECT * FROM Coefficients ORDER BY id DESC LIMIT 1;");
            cv = new CoefficientValues (res.getString("income"),res.getString("incomeNonResident"),res.getString("pension"),
                    res.getString("medical"),res.getString("social"),res.getString("insurance"));
        } catch (SQLException ex){
            System.out.println(ex.getMessage());
            throw new Exception("Coefficient reading error");
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

        return cv;
    }
    
}
