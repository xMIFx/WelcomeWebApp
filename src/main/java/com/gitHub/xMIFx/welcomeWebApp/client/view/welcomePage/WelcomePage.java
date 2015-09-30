package com.gitHub.xMIFx.welcomeWebApp.client.view.welcomePage;

import com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources.MainResources;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.IWelcomePageView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;

/**
 * WelcomePageView for UiBinder
 * Created by bukatinvv on 21.09.2015.
 */
public class WelcomePage extends Composite implements IWelcomePageView {
    private IWelcomePagePresenter presenter;

    @UiField(provided = true)
    final MainResources res;

    @UiField
    Label buttonExit;

    @UiField
    Label welcome;

    @Override
    public void setPresenter(IWelcomePagePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setHelloString(String helloString) {
        welcome.setText(helloString);
    }

    @UiTemplate("WelcomePage.ui.xml")
    interface WelcomePageUiBinder extends UiBinder<HTMLPanel, WelcomePage> {
    }

    private static WelcomePageUiBinder ourUiBinder = GWT.create(WelcomePageUiBinder.class);

    public WelcomePage() {
        this.res = GWT.create(MainResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("buttonExit")
    void onClick(ClickEvent e) {
        presenter.callServer();

    }
}