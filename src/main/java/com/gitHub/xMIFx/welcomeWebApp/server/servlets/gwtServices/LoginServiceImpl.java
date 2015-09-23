package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.DataBaseConfig;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MainSpringConfig;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;

/**
 * Created by Vlad on 20.09.2015.
 */
@Service("loginService")
public class LoginServiceImpl extends SpringGWTServlet implements LoginService {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);
    private static final String userAttributeSessionName = "user";
    private HttpSession httpSession;
    @Autowired
    private UserService userService;


    public String authorization(String login, String password, String localeName) {
        User user = null;
        try {
            user = userService.getByLoginPassword(login, password);
        } catch (NoSuchAlgorithmException e) {
            LOG.error("No Algorithm", e);
        } catch (InvalidKeySpecException e) {
            LOG.error("Invalid KeySpec", e);
        } catch (UnsupportedEncodingException e) {
            LOG.error("UnsupportedEncodingException", e);
        } catch (Throwable t){
            t.printStackTrace();
        }
        if (user == null) {
            return null;
        }
        httpSession = getThreadLocalRequest().getSession();
        httpSession = this.getThreadLocalRequest().getSession();
        httpSession.setAttribute(userAttributeSessionName, user);

        LOG.trace("Authorization successful");
        LOG.trace("locale from browser: " + localeName);
        Locale currentLocale = new Locale(localeName);

        return userService.getHelloMessageForUser(currentLocale, user);
    }
}
