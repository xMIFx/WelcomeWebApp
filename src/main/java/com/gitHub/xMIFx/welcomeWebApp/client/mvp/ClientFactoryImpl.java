package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.client.LoginServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.login.Login;
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
    private static final ILoginView loginView = new Login(loginServiceAsync);

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
}
