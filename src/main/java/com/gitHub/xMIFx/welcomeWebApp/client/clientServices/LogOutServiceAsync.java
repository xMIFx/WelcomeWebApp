package com.gitHub.xMIFx.welcomeWebApp.client.clientServices;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>LogOutService</code>
 * Created by bukatinvv on 22.09.2015.
 */
public interface LogOutServiceAsync {
    void logOut(AsyncCallback<Void> async);
}
