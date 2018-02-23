package com.school.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("SchoolService")
public interface SchoolService extends RemoteService {
    // Sample interface method of remote interface
    String getMessage(String msg);

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
