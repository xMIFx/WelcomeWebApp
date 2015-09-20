package com.gitHub.xMIFx.welcomeWebApp.client.login;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by Vlad on 19.09.2015.
 */
public interface  LoginResources extends ClientBundle {
    public interface MyCss extends CssResource {
        String blackText();

        String inlineBlock();

        String loginButton();

        String box();

        String background();
    }

    @Source("../../public/Login.css")
    MyCss style();
}

