package com.school.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("SchoolService")
public interface SchoolService extends RemoteService {

    List<String[]> getInfo();

    /**
     * Utility/Convenience class.
     * Use SchoolService.App.getInstance() to access static instance of SchoolServiceAsync
     */
    public static class App {
        private static SchoolServiceAsync ourInstance = GWT.create(SchoolService.class);

        public static synchronized SchoolServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
