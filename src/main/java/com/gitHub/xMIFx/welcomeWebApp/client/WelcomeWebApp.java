package com.gitHub.xMIFx.welcomeWebApp.client;

import com.gitHub.xMIFx.welcomeWebApp.client.footer.Footer;
import com.gitHub.xMIFx.welcomeWebApp.client.header.Header;
import com.gitHub.xMIFx.welcomeWebApp.client.login.Login;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WelcomeWebApp implements EntryPoint {

    private LoginServiceAsync loginServiceAsync = GWT.create(LoginService.class);

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("gwtContainer").add(new Header());
        RootPanel.get("gwtContainer").add(new Login(this.loginServiceAsync));
        RootPanel.get("gwtContainer").add(new Footer());
    }
}
