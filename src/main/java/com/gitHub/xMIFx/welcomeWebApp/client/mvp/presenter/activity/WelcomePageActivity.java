package com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.activity;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutService;
import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ClientFactory;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.LoginPlace;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.IWelcomePageView;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

/**
 * Send command to the server for logOut.
 * Change view after server response
 * Created by bukatinvv on 22.09.2015.
 */
public class WelcomePageActivity extends AbstractActivity
                     implements IWelcomePageView.IWelcomePagePresenter {
    private LogOutServiceAsync logOutServiceAsync = GWT.create(LogOutService.class);
    private ClientFactory clientFactory;
    private String helloString;

    public WelcomePageActivity(final String helloString,
                               final ClientFactory clientFactory) {
        this.clientFactory = clientFactory;
        this.helloString = helloString;
    }

    @Override
    public void start(final AcceptsOneWidget container,
                      final EventBus eventBus) {
        IWelcomePageView welcomePageView = clientFactory.getWelcomePageView();
        welcomePageView.setPresenter(this);
        welcomePageView.setHelloString(helloString);
        container.setWidget(welcomePageView.asWidget());
    }

    @Override
    public void callServer() {
        logOutServiceAsync.logOut(new AsyncCallback<Void>() {
            @Override
            public void onFailure(final Throwable throwable) {
                GWT.log("error logOut service", throwable);
            }

            @Override
            public void onSuccess(Void aVoid) {
                GWT.log("LogOut successful");
                goTo(new LoginPlace("login"));
            }
        });
    }

    @Override
    public void goTo(final Place place) {
        clientFactory.getPlaceController().goTo(place);
    }
}
