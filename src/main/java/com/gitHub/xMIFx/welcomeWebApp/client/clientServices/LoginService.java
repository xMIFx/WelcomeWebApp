package com.gitHub.xMIFx.welcomeWebApp.client.clientServices;

        import com.google.gwt.user.client.rpc.RemoteService;
        import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service
 * Created by Vlad on 20.09.2015.
 */
@RemoteServiceRelativePath("gwt/loginService")
public interface LoginService extends RemoteService {
    String authorization(String login, String password, String localeName);
}
