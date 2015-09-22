package com.gitHub.xMIFx.welcomeWebApp.client;

import com.gitHub.xMIFx.welcomeWebApp.client.footer.Footer;
import com.gitHub.xMIFx.welcomeWebApp.client.header.Header;
import com.gitHub.xMIFx.welcomeWebApp.client.login.LoginResources;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.AppActivityMapper;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.AppPlaceHistoryMapper;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ClientFactory;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.LoginPlace;
import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.web.bindery.event.shared.EventBus;


/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class WelcomeWebApp implements EntryPoint {


    final LoginResources res = GWT.create(LoginResources.class);
    private Place defaultPlace = new LoginPlace("World!");
    private SimplePanel appWidget = new SimplePanel();

    {
        appWidget.setStyleName(res.style().background());
    }

    /**
     * This is the entry point method.
     */
    public void onModuleLoad() {
        RootPanel.get("gwtContainer").add(new Header());

        ClientFactory clientFactory = GWT.create(ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper,
                eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = GWT
                .create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

        RootPanel.get("gwtContainer").add(appWidget);
        // Goes to place represented on URL or default place
        historyHandler.handleCurrentHistory();
        RootPanel.get("gwtContainer").add(new Footer());
    }
}
