package com.gitHub.xMIFx.welcomeWebApp.client.view.header;

import com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources.HeaderResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;

/**
 * Created by Vlad on 19.09.2015.
 */
public class Header extends Composite {
    @UiField(provided = true)
    final HeaderResources res;

    @UiTemplate("Header.ui.xml")
    interface HeaderUiBinder extends UiBinder<HTMLPanel, Header> {
    }

    private static HeaderUiBinder ourUiBinder = GWT.create(HeaderUiBinder.class);

    public Header() {
        this.res = GWT.create(HeaderResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}