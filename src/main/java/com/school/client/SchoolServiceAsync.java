package com.school.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

import java.util.List;

public interface SchoolServiceAsync {


    void getInfo(AsyncCallback<List<String[]>> async);
}
