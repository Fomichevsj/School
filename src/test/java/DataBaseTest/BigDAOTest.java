package DataBaseTest;

import com.school.CustomClasses.Student;
import com.school.DataBase.BigDAO;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class BigDAOTest {

    @Test
    public void getStudetnsOfClassTest() throws SQLException {
        BigDAO bigDAO = new BigDAO();
        List<Student> list = bigDAO.getStudents("11B");
        System.out.println("Фамилия     Имя     Отчество     Дата рождения");
        for (Student s: list
             ) {
            s.print();
        }
    }

    @Test
    public void addStudentTest() throws SQLException {
        BigDAO bigDAO = new BigDAO();
        bigDAO.addStudent("Fomichev", "Sergey", "Alexevich",
                "11B");
    }
}
