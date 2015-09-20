package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.gitHub.xMIFx.welcomeWebApp.client.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

/**
 * Created by Vlad on 20.09.2015.
 */
@Service("loginService")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
    @Autowired
    UserService userService;

    @Override
    public boolean authorization(String login, String password) {
        return false;
    }
}
