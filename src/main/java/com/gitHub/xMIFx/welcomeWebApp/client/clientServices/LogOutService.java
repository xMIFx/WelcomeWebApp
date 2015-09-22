package com.gitHub.xMIFx.welcomeWebApp.client.clientServices;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.google.gwt.core.client.GWT;

/**
 * Created by bukatinvv on 22.09.2015.
 */
@RemoteServiceRelativePath("gwt/logOutService")
public interface LogOutService extends RemoteService {

    void logOut();
}
