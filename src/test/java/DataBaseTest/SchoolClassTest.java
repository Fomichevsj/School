package DataBaseTest;

import com.school.DataBase.SchoolClass;
import org.testng.annotations.Test;

public class SchoolClassTest {

    @Test
    public void insert() {
        SchoolClass schoolClass = new SchoolClass("11-Б");
    }
}
