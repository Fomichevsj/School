package com.school.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.school.CustomClasses.Student;
import com.school.DataBase.BigDAO;
import com.school.DataBase.GetRandomLastName;
import com.school.DataBase.GetRandomMiddleName;
import com.school.DataBase.GetRandomName;
import com.school.client.SchoolService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SchoolServiceImpl extends RemoteServiceServlet implements SchoolService {
    public List<String[]> getInfo() {
        System.out.println("на сервере");
        List<Student> l = new ArrayList<Student>(30);
        BigDAO bigDAO = new BigDAO();
        try {
            l = bigDAO.getStudents("11B");
        } catch (SQLException sqle) {
            System.out.println("что-то пошло не так");
            sqle.printStackTrace();
        }

        List<String[]> res = new ArrayList<String[]>(30);
        for (Student s: l
                ) {
            s.print();
            res.add(new String[] {
                    s.LastName,
                    s.FirstName,
                    s.MiddleName,
                    "Y"
            });
        }
        return res;
    }
}