package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.ILoginView;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.IWelcomePageView;
import com.gitHub.xMIFx.welcomeWebApp.client.view.login.Login;
import com.gitHub.xMIFx.welcomeWebApp.client.view.welcomePage.WelcomePage;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

/**
 * Created by Vlad on 21.09.2015.
 */
public class ClientFactoryImpl implements ClientFactory {
    private static final EventBus EVENT_BUS = new SimpleEventBus();
    private static final PlaceController PLACE_CONTROLLER = new PlaceController(
            EVENT_BUS);
    private static final ILoginView LOGIN_VIEW = new Login();
    private static final IWelcomePageView WELCOME_PAGE_VIEW = new WelcomePage();

    @Override
    public EventBus getEventBus() {
        return EVENT_BUS;
    }

    @Override
    public PlaceController getPlaceController() {
        return PLACE_CONTROLLER;
    }

    @Override
    public ILoginView getLoginView() {
        return LOGIN_VIEW;
    }

    @Override
    public IWelcomePageView getWelcomePageView() {
        return WELCOME_PAGE_VIEW;
    }


}
