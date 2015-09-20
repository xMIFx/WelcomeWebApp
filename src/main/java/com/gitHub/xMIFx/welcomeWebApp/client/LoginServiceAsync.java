package com.gitHub.xMIFx.welcomeWebApp.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
    void authorization(String login, String password, AsyncCallback<Boolean> async);
}
