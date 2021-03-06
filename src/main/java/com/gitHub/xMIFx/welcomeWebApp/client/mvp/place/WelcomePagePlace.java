package com.gitHub.xMIFx.welcomeWebApp.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by bukatinvv on 22.09.2015.
 */
public class WelcomePagePlace extends Place {
    private String welcomePageName;

    public WelcomePagePlace(final String welcomePageName) {
        this.welcomePageName = welcomePageName;
    }

    public String getWelcomePageName() {
        return welcomePageName;
    }

    public static class Tokenizer implements PlaceTokenizer<WelcomePagePlace> {

        @Override
        public String getToken(final WelcomePagePlace place) {
            return place.getWelcomePageName();
        }

        @Override
        public WelcomePagePlace getPlace(final String token) {
            return new WelcomePagePlace(token);
        }

    }
}
