package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.gitHub.xMIFx.welcomeWebApp.client.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserServiceImpl;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.DataBaseConfig;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MainSpringConfig;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by Vlad on 20.09.2015.
 */
@Service("loginService")
public class LoginServiceImpl extends RemoteServiceServlet implements LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
    private HttpSession httpSession;
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        AnnotationConfigApplicationContext ctx= new AnnotationConfigApplicationContext();
        ctx.register(MainSpringConfig.class);
        ctx.register(DataBaseConfig.class);
        ctx.refresh();
        ctx.start();
        userService = (UserService)ctx.getBean("userService");
    }

    public boolean authorization(String login, String password) {
        User user = null;
        try {
            user = userService.getByLoginPassword(login, password);
        } catch (NoSuchAlgorithmException e) {
            LOG.error("No Algorithm", e);
        } catch (InvalidKeySpecException e) {
            LOG.error("Invalid KeySpec", e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("UnsupportedEncodingException", e);
        }
        if (user == null) {
            return false;
        }
        httpSession = getThreadLocalRequest().getSession();
        httpSession = this.getThreadLocalRequest().getSession();
        httpSession.setAttribute("user",user);
        return true;
    }
}
