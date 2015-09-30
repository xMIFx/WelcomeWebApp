package com.gitHub.xMIFx.welcomeWebApp.client.clientServices;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>LoginService</code>
 * Created by bukatinvv on 22.09.2015.
 */

public interface LoginServiceAsync {
    void authorization(String login, String password, String localeName, AsyncCallback<String> async);
}
