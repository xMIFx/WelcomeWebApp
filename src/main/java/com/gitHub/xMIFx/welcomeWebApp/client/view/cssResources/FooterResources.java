package com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources;

import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;

/**
 * Created by Vlad on 19.09.2015.
 */
public interface FooterResources extends ClientBundle {
    public interface MyCss extends CssResource {
        String blackText();

        String footer();
    }

    @Source("../../../public/Footer.css")
    MyCss style();
}
