package com.school.DataBase;

import com.school.CustomClasses.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BigDAO {
    public Connection con;

   public BigDAO() {
       con = BaseHelper.getConnection();
   }

   public List<Student> getStudents(String className) throws SQLException {
       String query = String.format("-- Получить информацию об учениках которые учатся в определенном классе\n" +
               "select\n" +
               "s.\"Id\",\n" +
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
               "\tand c.\"Name\" = '%s'\n",
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

   public void addStudent(String lastName, String firstName,
                          String middleName,
                          String cassName) throws SQLException {
       String classId = ";";
       String getClassId = "select * from \"School\".\"Class\" where \"Name\" = '" +cassName + "'";
       Statement statement = con.createStatement();
       ResultSet resultSet = statement.executeQuery(getClassId);
       if(resultSet.next()) {
           classId = resultSet.getString("Id");
       }
       String query = String.format("INSERT  into \"School\".\"Student\"(" +
                       "\"Id\", \"LastName\", \"FirstName\", \"MiddleName\", \"ClassId\")\n" +
                       "VALUES (uuid_in('%s'), '%s', '%s','%s', uuid_in('%s'));",
               UUID.randomUUID(),
               lastName,
               firstName,
               middleName,
               classId);
       System.out.println(query);
        statement.executeUpdate(query);
        statement.close();
        con.close();

   }
}
