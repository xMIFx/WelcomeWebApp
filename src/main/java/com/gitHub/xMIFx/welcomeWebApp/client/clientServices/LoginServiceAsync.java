package com.gitHub.xMIFx.welcomeWebApp.client.clientServices;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoginServiceAsync {
    void authorization(String login, String password, AsyncCallback<String> async);
}
