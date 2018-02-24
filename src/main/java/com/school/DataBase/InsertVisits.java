package com.school.DataBase;

import com.school.CustomClasses.Student;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.UUID;

public class InsertVisits {
    public static void push(List<Boolean> booleanList, String className) {
        try {
            List<Student> l = Students.getStudents(className);
            int i = 0;
            for (Student s:l
                 ) {
                insertRow(s, booleanList.get(i++));
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    private static void insertRow(Student s, Boolean aBoolean) {
        String insert = String.format("INSERT INTO \"School\".\"Visit\"(\n" +
                "\t\"Id\", \"StudentId\", \"Date\", \"Status\")\n" +
                "\tVALUES (uuid_in('%s'), uuid_in('%s'), '%s', %s);",
                UUID.randomUUID(),
                s.Id,
                new Date(System.currentTimeMillis()),
                !aBoolean
                );
        Connection con = BaseHelper.getConnection();
        Statement st = null;
        try {
            st = con.createStatement();
            st.executeUpdate(insert);
            System.out.println(insert);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } finally {
            try {
                if(st != null) {
                    st.close();
                }
                con.close();
            } catch (SQLException s2) {
                s2.printStackTrace();
            }
        }
    }
}
