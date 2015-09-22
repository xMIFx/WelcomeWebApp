package com.gitHub.xMIFx.welcomeWebApp.client.welcomePage;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LogOutServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.login.LoginResources;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.IWelcomePageView;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.LoginPlace;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.WelcomePagePlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * Created by bukatinvv on 21.09.2015.
 */
public class WelcomePage extends Composite implements IWelcomePageView {
    private IWelcomePagePresenter presenter;

    @UiField(provided = true)
    final LoginResources res;

    @UiField
    Label buttonExit;

    @UiField
    Label welcome;

    private final LogOutServiceAsync logOutServiceAsync;

    @Override
    public void setPresenter(IWelcomePagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setHelloString(String helloString) {
        welcome.setText(helloString);
    }

    interface WelcomePageUiBinder extends UiBinder<HTMLPanel, WelcomePage> {
    }

    private static WelcomePageUiBinder ourUiBinder = GWT.create(WelcomePageUiBinder.class);

    public WelcomePage(LogOutServiceAsync logOutServiceAsync) {
        this.logOutServiceAsync = logOutServiceAsync;
        this.res = GWT.create(LoginResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("buttonExit")
    void onClick(ClickEvent e) {
        logOutOnServer();

    }

    private void logOutOnServer() {
        logOutServiceAsync.logOut(new AsyncCallback<Void>() {
            @Override
            public void onFailure(Throwable throwable) {
                GWT.log("error logOut service", throwable);
            }

            @Override
            public void onSuccess(Void aVoid) {
                GWT.log("LogOut successful");
                presenter.goTo(new LoginPlace("login"));
            }
        });
    }


}