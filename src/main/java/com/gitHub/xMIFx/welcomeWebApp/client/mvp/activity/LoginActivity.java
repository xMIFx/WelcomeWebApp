package com.gitHub.xMIFx.welcomeWebApp.client.mvp.activity;

import com.gitHub.xMIFx.welcomeWebApp.client.login.Login;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ClientFactory;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ILoginView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Created by Vlad on 21.09.2015.
 */
public class LoginActivity extends AbstractActivity implements ILoginView.ILoginPresenter{
    private ClientFactory clientFactory;

    public LoginActivity(ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(AcceptsOneWidget container, EventBus eventBus) {
        ILoginView loginView = clientFactory.getLoginView();
        loginView.setPresenter(this);
        container.setWidget(loginView.asWidget());

    }

    @Override
    public void goTo(Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
