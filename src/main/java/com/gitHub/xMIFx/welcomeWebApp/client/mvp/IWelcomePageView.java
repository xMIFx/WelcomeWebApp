package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

        import com.google.gwt.place.shared.Place;
        import com.google.gwt.user.client.ui.IsWidget;

/**
 * Created by bukatinvv on 22.09.2015.
 */
public interface IWelcomePageView extends IsWidget {

    public void setPresenter(IWelcomePagePresenter presenter);

    public void setHelloString(String helloString);

    public interface IWelcomePagePresenter {
        void goTo(Place place);
    }
}
