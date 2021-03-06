package com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * inject Main.css in view
 * Created by Vlad on 19.09.2015.
 */
public interface MainResources extends ClientBundle {
    interface MyCss extends CssResource {
        String blackText();

        String inlineBlock();

        String loginButton();

        String box();

        String background();

        String center();

        String holderText();

        String leftText();

        String exitButton();

        String welcomeBackground();
    }

    @Source("../../../public/Main.css")
    MyCss style();
}

