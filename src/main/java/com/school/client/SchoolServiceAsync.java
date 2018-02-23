package com.school.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SchoolServiceAsync {
    void getMessage(String msg, AsyncCallback<String> async);
}
