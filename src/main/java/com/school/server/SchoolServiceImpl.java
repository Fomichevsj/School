package com.school.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.school.client.SchoolService;

public class SchoolServiceImpl extends RemoteServiceServlet implements SchoolService {

    public String[] getInfo() {
        String[] res = new String[] {
                "Фомичев",
                "Сергей",
                "Алексеевич",
                "Y"
        };
        System.out.println("Пытаюсь вернуть строчку");
        return res;
    }
}