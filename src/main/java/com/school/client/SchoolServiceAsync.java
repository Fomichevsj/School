package com.school.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SchoolServiceAsync {

    void getInfo(AsyncCallback<String[]> async);
}
