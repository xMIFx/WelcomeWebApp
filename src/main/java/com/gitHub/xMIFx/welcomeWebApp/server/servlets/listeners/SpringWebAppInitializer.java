package com.gitHub.xMIFx.welcomeWebApp.server.servlets.listeners;

import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MainSpringConfig;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MvcConfig;
import org.spring4gwt.server.SpringGwtRemoteServiceServlet;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Vlad on 20.09.2015.
 */
public class SpringWebAppInitializer  /*extends AbstractAnnotationConfigDispatcherServletInitializer*/ {
    /*@Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{MainSpringConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"*//*"};
    }

    @Override
    protected void registerContextLoaderListener(ServletContext servletContext) {
        super.registerContextLoaderListener(servletContext);
    }

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        super.onStartup(container);
        ServletRegistration.Dynamic testServlet = container.addServlet("gwtServlet", new SpringGwtRemoteServiceServlet());
        testServlet.addMapping("/welcomeWebApp/gwt*//*");
    }*/
}
