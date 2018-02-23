package com.school;

import com.school.CustomClasses.Student;
import com.school.DataBase.BigDAO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

public class CreateHTML {
    private static final String path = "/Users/fomichevalexey/IdeaProjects/School/war/Table.html";
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        BigDAO bigDAO = new BigDAO();
        List<Student> list = bigDAO.getStudents("11B");
        System.setOut(new PrintStream( new FileOutputStream(path), true));
        System.out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title>Кодировка HTML-страницы</title>\n" +
                "    <style>\n" +
                "        #students {\n" +
                "            font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
                "            border-collapse: collapse;\n" +
                "            width: 100%;\n" +
                "        }\n" +
                "\n" +
                "        #students td, #students th {\n" +
                "            border: 1px solid #ddd;\n" +
                "            padding: 8px;\n" +
                "        }\n" +
                "\n" +
                "        #students tr:nth-child(even){background-color: #f2f2f2;}\n" +
                "\n" +
                "        #students tr:hover {background-color: #ddd;}\n" +
                "\n" +
                "        #students th {\n" +
                "            padding-top: 12px;\n" +
                "            padding-bottom: 12px;\n" +
                "            text-align: left;\n" +
                "            background-color: #4CAF50;\n" +
                "            color: white;\n" +
                "        }\n" +
                "        .sendButton {\n" +
                        "            background-color: #4CAF50; /* Green */\n" +
                        "            border: none;\n" +
                        "            color: white;\n" +
                        "            padding: 20px;\n" +
                        "            text-align: center;\n" +
                        "            text-decoration: none;\n" +
                        "            display: inline-block;\n" +
                        "            font-size: 16px;\n" +
                        "            margin: 4px 2px;\n" +
                        "            cursor: pointer;\n" +
                        "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>");
        System.out.println("<h1 align=\"center\">Мой класс</h1>");
        System.out.println("<table id=\"students\">");
        System.out.println("    <tr>\n" +
                "        <th>Фамилия</th>\n" +
                "        <th>Имя</th>\n" +
                "        <th>Отчество</th>\n" +
                "        <th>Был или не был</th>\n" +
                "    </tr>");
        for (Student s: list
             ) {
            System.out.println("" +
                    "\t<tr>\n" +
                    "\t\t<td>" +
                    s.LastName +
                    "\t</td>\n" +
                    "\t\t<td>" +
                    s.FirstName +
                    "</td>\n" +
                    "\t\t<td>" +
                    s.MiddleName +
                    "</td>\n" +
                    "\t\t<td>" +
                    "<input type=\"checkbox\">  Был" +
                    "</td>" + "\n</tr>");
        }
        System.out.println("</table>\n");
        System.out.println("<p align=\"centre\" id = \"statusLabel\"><label>Отправить информацию</label></p>\n" +
                "<button onclick=\"disableFunction()\" id = \"sendInfoButton\" class = \"sendButton\">Отправить</button>\n" +
                "<script>\n" +
                "    function disableFunction() {\n" +
                "        document.getElementById('statusLabel').innerText = 'Информация отправлена';\n" +
                "    }\n" +
                "</script>\n");
        System.out.println("\n" +
                "</body>\n" +
                "</html>\n");
        bigDAO.con.close();
    }
}
