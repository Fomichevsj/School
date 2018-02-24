package com.school.DataBase;

import com.school.CustomClasses.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Students {

    private UUID Id;
    public String LastName;
    public String FirstName;
    public String MiddleName;
    public String BirthDate;
    public String Class;


    public void insertRandomRow() throws SQLException {
        Connection con = BaseHelper.getConnection();
        Statement st = con.createStatement();

        Id = UUID.randomUUID();
        LastName = GetRandomLastName.lastName();
        FirstName = GetRandomName.firstName();
        MiddleName = GetRandomMiddleName.middleName();
        BirthDate = "";
        Class = "a90c7d68-2e2a-973d-11c9-a96490b4d554";

        String sql = String.format("INSERT  into \"School\".\"Student\"(" +
                "\"Id\", \"LastName\", \"FirstName\", \"MiddleName\", \"ClassId\")\n" +
                "VALUES (uuid_in('%s'), '%s', '%s', '%s', uuid_in('%s'));",
                Id,
                LastName,
                FirstName,
                MiddleName,
                Class);
        System.out.println(sql);
                st.executeUpdate(sql);
                st.close();
                con.close();
    }

    public static List<Student> getStudents(String className) throws SQLException {
        Connection con = BaseHelper.getConnection();
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
                    resultSet.getString("BirthDate"),
                    resultSet.getString("Id")));
        }
        st.close();
        con.close();
        return list;
    }


}
