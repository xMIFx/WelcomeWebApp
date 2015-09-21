package com.gitHub.xMIFx.welcomeWebApp.client.mvp;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.LoginPlace;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 * Created by Vlad on 21.09.2015.
 */
@WithTokenizers({LoginPlace.Tokenizer.class/*, GoodbyePlace.Tokenizer.class*/})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}
