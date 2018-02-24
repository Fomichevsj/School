package com.school.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;

import java.util.List;

public interface SendStatusServiceAsync {
    void sendInfo(List<Boolean> booleanList, AsyncCallback<Void> async);
}
