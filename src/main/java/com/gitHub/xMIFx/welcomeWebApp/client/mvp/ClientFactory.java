package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.ILoginView;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.IWelcomePageView;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.event.shared.EventBus;

/**
 * Created by Vlad on 21.09.2015.
 */
public interface ClientFactory {

    EventBus getEventBus();

    PlaceController getPlaceController();

    ILoginView getLoginView();

    IWelcomePageView getWelcomePageView();
}
