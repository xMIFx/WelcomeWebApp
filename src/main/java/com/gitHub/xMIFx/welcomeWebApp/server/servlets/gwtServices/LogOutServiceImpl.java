package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by bukatinvv on 22.09.2015.
 */
@Service("logoutService")
public class LogOutServiceImpl extends SpringGWTServlet implements LogOutService {
    private static final Logger LOG = LoggerFactory.getLogger(LogOutServiceImpl.class);
    private static final String USER_ATTRIBUTE_SESSION_NAME = "user";

    private HttpSession httpSession;

    @Override
    public void logOut() {
        httpSession = getThreadLocalRequest().getSession();
        httpSession.removeAttribute(USER_ATTRIBUTE_SESSION_NAME);
        LOG.trace("LogOut successful");
    }
}