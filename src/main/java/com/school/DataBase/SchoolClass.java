package com.school.DataBase;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

public class SchoolClass {

    public String id;
    public String name;
    public String teacherId;

    public SchoolClass(String name) {
        Connection con = BaseHelper.getConnection();
        Statement statement = null;
        try {
            statement = con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = null;
        try {
            query = FileUtils.readFileToString(new File("C:\\Users\\safomichev\\IdeaProjects\\School\\resources\\SQLScripts\\insertNewClass.sql"));
        } catch (IOException io) {
            io.printStackTrace();
        }
        if (query != null) {
            query = String.format(query, UUID.randomUUID(), name);
            System.out.println("Запрос для создания новой записи класса:\n" + query);
            try {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Не смогли создать новый класс");
        }
    }
}
