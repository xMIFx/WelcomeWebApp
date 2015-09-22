package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.activity.LoginActivity;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.activity.WelcomePageActivity;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.LoginPlace;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.WelcomePagePlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

/**
 * Created by Vlad on 21.09.2015.
 */
public class AppActivityMapper implements ActivityMapper {
    private ClientFactory clientFactory;

    public AppActivityMapper(ClientFactory clientFactory) {
        super();
        this.clientFactory = clientFactory;
    }

    @Override
    public Activity getActivity(Place place) {
        if (place instanceof LoginPlace) {
            return new LoginActivity(clientFactory);
        } else if (place instanceof WelcomePagePlace) {
            return new WelcomePageActivity(((WelcomePagePlace) place).getWelcomePageName(),clientFactory);
        }
        return null;
    }
}
