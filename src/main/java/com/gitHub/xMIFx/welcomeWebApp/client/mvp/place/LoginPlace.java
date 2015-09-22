package com.gitHub.xMIFx.welcomeWebApp.client.mvp.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

/**
 * Created by Vlad on 21.09.2015.
 */
public class LoginPlace extends Place {
    private String loginName;

    public LoginPlace(String token) {
        this.loginName = token;
    }

    public String getLoginName() {
        return loginName;
    }

    public static class Tokenizer implements PlaceTokenizer<LoginPlace> {

        @Override
        public String getToken(LoginPlace place) {
            return place.getLoginName();
        }

        @Override
        public LoginPlace getPlace(String token) {
            return new LoginPlace(token);
        }

    }
}
