package com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter;

        import com.google.gwt.place.shared.Place;
        import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by bukatinvv on 22.09.2015.
 */
public interface IWelcomePageView extends IsWidget {

    void setPresenter(IWelcomePagePresenter presenter);

    void setHelloString(String helloString);

    public interface IWelcomePagePresenter {
        void callServer();
        void goTo(Place place);
    }
}
