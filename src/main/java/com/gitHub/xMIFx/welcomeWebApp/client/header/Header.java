package com.gitHub.xMIFx.welcomeWebApp.client.header;

import com.gitHub.xMIFx.welcomeWebApp.client.footer.FooterResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;

/**
 * Created by Vlad on 19.09.2015.
 */
public class Header extends Composite {
    @UiField(provided = true)
    final HeaderResources res;

    interface HeaderUiBinder extends UiBinder<HTMLPanel, Header> {
    }

    private static HeaderUiBinder ourUiBinder = GWT.create(HeaderUiBinder.class);

    public Header() {
        this.res = GWT.create(HeaderResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }
}