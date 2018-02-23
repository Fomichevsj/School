package com.school.DataBase;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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


}
