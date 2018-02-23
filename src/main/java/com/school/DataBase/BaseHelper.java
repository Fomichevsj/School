package com.school.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseHelper {
    private static Connection con;

    public static Connection getConnection() {
        try {
            con = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/School",
                            "postgres", "qwerty");
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return con;
    }
}
