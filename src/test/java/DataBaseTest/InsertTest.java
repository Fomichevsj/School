package DataBaseTest;

import com.school.DataBase.Students;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class InsertTest {

    @Test
    public void insert() {
        for(int i = 0; i < 10; i++) {
            Students students = new Students();
            try {
                students.insertRandomRow("11-Б");
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }
    }
}
