package com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

/**
 * Created by Vlad on 19.09.2015.
 */
public interface HeaderResources extends ClientBundle{
    public interface MyCss extends CssResource {
        String header();
        String logoStyle();
    }

    @Source("../../../public/Header.css")
    MyCss style();

    @Source("../../../public/logo.png")
    ImageResource logo();
}
