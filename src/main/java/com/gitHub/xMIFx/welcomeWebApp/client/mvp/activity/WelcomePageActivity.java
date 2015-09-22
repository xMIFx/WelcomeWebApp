package com.gitHub.xMIFx.welcomeWebApp.client.mvp.activity;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ClientFactory;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.IWelcomePageView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by bukatinvv on 22.09.2015.
 */
public class WelcomePageActivity extends AbstractActivity implements IWelcomePageView.IWelcomePagePresenter {
    private ClientFactory clientFactory;
    private String helloString;
    public WelcomePageActivity(String helloString, ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.helloString = helloString;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        IWelcomePageView welcomePageView = clientFactory.getWelcomePageView();
        welcomePageView.setPresenter(this);
        welcomePageView.setHelloString(helloString);
        container.setWidget(welcomePageView.asWidget());
    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
