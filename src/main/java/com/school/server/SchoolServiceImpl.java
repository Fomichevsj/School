package com.school.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.school.DataBase.GetRandomLastName;
import com.school.DataBase.GetRandomMiddleName;
import com.school.DataBase.GetRandomName;
import com.school.client.SchoolService;

import java.util.ArrayList;
import java.util.List;

public class SchoolServiceImpl extends RemoteServiceServlet implements SchoolService {

    public List<String[]> getInfo() {
        System.out.println("На серваке. Буду возращать данные");
        int capacity = 10;
        List<String[]> l = new ArrayList<String[]>(capacity);
        for (int i = 0; i < capacity; i++) {
            System.out.println("Добавляю имя");
            l.add(new String[] {
                    GetRandomLastName.lastName(),
                    GetRandomName.firstName(),
                    GetRandomMiddleName.middleName(),
                    "Y"
            });
        }
        System.out.println(l);
        return l;
    }
}