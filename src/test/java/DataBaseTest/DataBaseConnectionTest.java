package DataBaseTest;

import com.school.DataBase.BaseHelper;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnectionTest {
    @Test
    public void t() {
        Connection con = BaseHelper.getConnection();
        Statement st = null;
        try {
            st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from \"School\".\"Teacher\"");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("LastName"));
            }


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException sq) {
                sq.printStackTrace();
            }
        }
    }
}
