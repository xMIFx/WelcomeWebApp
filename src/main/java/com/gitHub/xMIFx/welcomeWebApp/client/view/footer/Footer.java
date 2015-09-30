package com.gitHub.xMIFx.welcomeWebApp.client.view.footer;


import com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources.FooterResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * FooterView for UiBinder
 * Created by Vlad on 19.09.2015.
 */
public class Footer extends Composite {
    @UiField(provided = true)
    final FooterResources res;

    @UiTemplate("Footer.ui.xml")
    interface FooterUiBinder extends UiBinder<HTMLPanel, Footer> {
    }

    private static FooterUiBinder ourUiBinder = GWT.create(FooterUiBinder.class);

    public Footer() {
        this.res = GWT.create(FooterResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }


}