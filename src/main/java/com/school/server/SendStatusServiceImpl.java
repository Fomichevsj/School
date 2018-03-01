package com.school.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.school.DataBase.InsertVisits;
import com.school.client.SendStatusService;

import java.util.List;

public class SendStatusServiceImpl extends RemoteServiceServlet implements SendStatusService {
    public void sendInfo(List<Boolean> booleanList) {
        System.out.println("Значение которая пришли с сервака");
        InsertVisits.push(booleanList, "11-Б");
        for (Boolean b: booleanList
             ) {
            System.out.println(b);
        }
    }
}
