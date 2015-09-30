package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;


import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * class for turn on Spring @Autowired in GWT servlet
 * Created by bukatinvv on 21.09.2015.
 */

public class SpringGWTServlet extends RemoteServiceServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContextUtils.
                getRequiredWebApplicationContext(config.getServletContext()).
                getAutowireCapableBeanFactory().
                autowireBean(this);
    }
}
