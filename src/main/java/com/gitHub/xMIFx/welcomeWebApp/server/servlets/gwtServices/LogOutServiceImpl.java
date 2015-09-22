package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by bukatinvv on 22.09.2015.
 */
@Service("logoutService")
public class LogOutServiceImpl extends RemoteServiceServlet implements LogOutService {
    private static final Logger LOG = LoggerFactory.getLogger(LogOutServiceImpl.class);
    private HttpSession httpSession;
    private static final String userAttributeSessionName = "user";
    @Override
    public void logOut() {
        httpSession = getThreadLocalRequest().getSession();
        httpSession.removeAttribute(userAttributeSessionName);
        LOG.trace("LogOut successful");
    }
}