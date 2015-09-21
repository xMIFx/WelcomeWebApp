package com.gitHub.xMIFx.welcomeWebApp.server.servlets.gwtServices;

import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserServiceImpl;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.DataBaseConfig;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MainSpringConfig;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

/**
 * Created by bukatinvv on 21.09.2015.
 */

public class SpringGWTServlet /*extends RemoteServiceServlet*/ {
    /*private static  AnnotationConfigApplicationContext ctx;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
         ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(MainSpringConfig.class);
        ctx.register(DataBaseConfig.class);
        ctx.refresh();
        ctx.start();
        *//*WebApplicationContextUtils.
                getRequiredWebApplicationContext(config.getServletContext()).
                getAutowireCapableBeanFactory().
                autowireBean(this);*//* //java.lang.IllegalStateException: No WebApplicationContext found: no ContextLoaderListener registered?
    }

    public static Object getBean(Class clazz){
       return ctx.getBean(clazz);
    }*/
}
