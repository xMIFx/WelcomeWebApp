package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutService;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.login.Login;
import com.gitHub.xMIFx.welcomeWebApp.client.welcomePage.WelcomePage;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Created by Vlad on 21.09.2015.
 */
public class ClientFactoryImpl implements ClientFactory {
    private static final EventBus eventBus = new SimpleEventBus();
    private static final PlaceController placeController = new PlaceController(
            eventBus);
    private static LoginServiceAsync loginServiceAsync = GWT.create(LoginService.class);
    private static LogOutServiceAsync logOutServiceAsync = GWT.create(LogOutService.class);
    private static final ILoginView loginView = new Login(loginServiceAsync);
    private static final IWelcomePageView welcomePageView = new WelcomePage(logOutServiceAsync);

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    @Override
    public PlaceController getPlaceController() {
        return placeController;
    }

    @Override
    public ILoginView getLoginView() {
        return loginView;
    }

    @Override
    public IWelcomePageView getWelcomePageView() {
        return welcomePageView;
    }
}
