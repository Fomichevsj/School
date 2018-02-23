package com.school.DataBase;

import com.school.CustomClasses.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BigDAO {
    public Connection con;

   public BigDAO() {
       con = BaseHelper.getConnection();
   }

   public List<Student> getStudents(String className) throws SQLException {
       String query = String.format("-- Получить информацию об учениках которые учатся в определенном классе\n" +
               "select\n" +
               "s.\"LastName\",\n" +
               "s.\"FirstName\",\n" +
               "s.\"MiddleName\",\n" +
               "s.\"BirthDate\",\n" +
               "c.\"Name\"\n" +
               "from\n" +
               "\t\"School\".\"Student\" s,\n" +
               "\t\"School\".\"Class\" c\n" +
               "where\n" +
               "\ts.\"ClassId\" = c.\"Id\"\n" +
               "\tand c.\"Name\" = '%s'",
               className);
       System.out.println(query);
       Statement st = con.createStatement();
       ResultSet resultSet = st.executeQuery(query);
       List<Student> list = new ArrayList<Student>(16);
       while (resultSet.next()) {
           list.add(new Student(resultSet.getString("LastName"),
                   resultSet.getString("FirstName"),
                   resultSet.getString("MiddleName"),
                   resultSet.getString("BirthDate")));
       }
       return list;
   }
}
