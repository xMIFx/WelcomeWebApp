package com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by Vlad on 21.09.2015.
 */
public interface ILoginView extends IsWidget {

    void setPresenter(ILoginPresenter presenter);

    void setTextToPasswordBox(String password);

    interface ILoginPresenter {
        void callServer(String login, String password, String localeName);

        void goTo(Place place);
    }
}
