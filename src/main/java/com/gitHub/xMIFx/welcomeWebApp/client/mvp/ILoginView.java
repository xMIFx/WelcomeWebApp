package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

/**
 * Created by Vlad on 21.09.2015.
 */
public interface ILoginView extends IsWidget {

    public void setPresenter(ILoginPresenter presenter);

    public interface ILoginPresenter {
        void goTo(Place place);}
}
