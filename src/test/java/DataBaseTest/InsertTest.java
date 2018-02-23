package DataBaseTest;

import com.school.DataBase.Students;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class InsertTest {

    @Test
    public void insert() {
        Students students = new Students();
        try {
            students.insertRandomRow();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
