package com.school.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.util.List;

@RemoteServiceRelativePath("SendService")
public interface SendStatusService extends RemoteService  {
    void sendInfo(List<Boolean> booleanList);

    /**
     * Utility/Convenience class.
     * Use SchoolService.App.getInstance() to access static instance of SchoolServiceAsync
     */
    public static class App {
        private static SendStatusServiceAsync ourInstance = GWT.create(SendStatusService.class);

        public static synchronized SendStatusServiceAsync getInstance() {
            return ourInstance;
        }
    }
}
