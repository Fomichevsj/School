package DataBaseTest;

import com.school.DataBase.GetRandomLastName;
import com.school.DataBase.GetRandomMiddleName;
import com.school.DataBase.GetRandomName;
import org.testng.annotations.Test;

public class GetRandomLastNameTest {
    @Test
    public void t() {
        for (int i = 0; i < 250; i++) {
            System.out.println(GetRandomLastName.lastName() +
            " " + GetRandomName.firstName() +
            " " + GetRandomMiddleName.middleName());
        }
    }
}
