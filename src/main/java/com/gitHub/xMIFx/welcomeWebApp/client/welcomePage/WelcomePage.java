package com.gitHub.xMIFx.welcomeWebApp.client.welcomePage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created by bukatinvv on 21.09.2015.
 */
public class WelcomePage extends Composite {
    interface WelcomePageUiBinder extends UiBinder<HTMLPanel, WelcomePage> {
    }

    private static WelcomePageUiBinder ourUiBinder = GWT.create(WelcomePageUiBinder.class);

    public WelcomePage() {
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}