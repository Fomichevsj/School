package com.school.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.school.client.SchoolService;

public class SchoolServiceImpl extends RemoteServiceServlet implements SchoolService {
    // Implementation of sample interface method
    public String getMessage(String msg) {
        return "Client said: \"" + msg + "\"<br>Server answered: \"Hi!\"";
    }
}