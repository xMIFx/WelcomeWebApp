package com.gitHub.xMIFx.welcomeWebApp.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by Vlad on 20.09.2015.
 */
@RemoteServiceRelativePath("gwt/loginService")
public interface LoginService  extends RemoteService{
    boolean authorization(String login, String password);
}
