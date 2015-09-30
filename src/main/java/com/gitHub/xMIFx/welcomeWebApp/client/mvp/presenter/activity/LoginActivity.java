package com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.activity;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginService;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ClientFactory;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.ILoginView;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.WelcomePagePlace;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Send user credentials to the server for authentification and authorisation.
 * Processing server response
 * Created by Vlad on 21.09.2015.
 */
public class LoginActivity extends AbstractActivity
                                implements ILoginView.ILoginPresenter {
    private LoginServiceAsync loginServiceAsync = GWT.create(
                                                        LoginService.class);
    private ClientFactory clientFactory;

    public LoginActivity(final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
    }

    @Override
    public void start(final AcceptsOneWidget container,
                      final EventBus eventBus) {
        ILoginView loginView = clientFactory.getLoginView();
        loginView.setPresenter(this);
        loginView.setTextToPasswordBox("");
        container.setWidget(loginView.asWidget());

    }

    @Override
    public void callServer(final String login,
                           final String password,
                           final String localeName) {

        loginServiceAsync.authorization(login, password,
                localeName, new AsyncCallback<String>() {
            @Override
            public void onFailure(final Throwable caught) {
                GWT.log("error login service", caught);
            }

            @Override
            public void onSuccess(final String result) {
                if (result != null) {
                    GWT.log("Authorization successful");
                    goTo(new WelcomePagePlace(result));
                } else {
                    GWT.log("Authorization failed");
                }
            }
        });
    }

    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
