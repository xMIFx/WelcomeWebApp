package com.gitHub.xMIFx.welcomeWebApp.client.login;

import com.gitHub.xMIFx.welcomeWebApp.client.clientServices.LoginServiceAsync;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.ILoginView;
import com.gitHub.xMIFx.welcomeWebApp.client.mvp.place.WelcomePagePlace;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;


/**
 * Created by Vlad on 19.09.2015.
 */
public class Login extends Composite implements ILoginView {

    @UiField(provided = true)
    final LoginResources res;

    @UiField
    TextBox loginBox;

    @UiField
    TextBox passwordBox;

    @UiField
    Button buttonSubmit;

    private Boolean tooShort = true;

    private final LoginServiceAsync loginServiceAsync;

    private ILoginPresenter presenter;

    @Override
    public void setPresenter(ILoginPresenter presenter) {
        this.presenter = presenter;

    }

    @UiTemplate("Login.ui.xml")
    interface LoginUiBinder extends UiBinder<HTMLPanel, Login> {
    }

    private static LoginUiBinder ourUiBinder = GWT.create(LoginUiBinder.class);

    public Login(LoginServiceAsync loginServiceAsync) {
        this.res = GWT.create(LoginResources.class);
        this.loginServiceAsync = loginServiceAsync;
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @UiHandler("loginBox")
    void handleLoginChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 1) {
            tooShort = true;
        } else {
            tooShort = false;
        }
    }

    @UiHandler("passwordBox")
    void handlePasswordChange(ValueChangeEvent<String> event) {
        if (event.getValue().length() < 1) {
            tooShort = true;
        } else {
            tooShort = false;
        }
    }

    @UiHandler("buttonSubmit")
    void onClick(ClickEvent e) {
        if (!tooShort) {
            sendInfoToServer();
        }
        else {
            GWT.log("Login or password too short");
        }
    }

    private void sendInfoToServer() {

        loginServiceAsync.authorization(loginBox.getText(), passwordBox.getText(),  LocaleInfo.getCurrentLocale().getLocaleName(), new AsyncCallback<String>() {
            @Override
            public void onFailure(Throwable caught) {
                GWT.log("error login service", caught);
            }

            @Override
            public void onSuccess(String result) {
                if (result!=null) {
                    GWT.log("Authorization successful");
                    presenter.goTo(new WelcomePagePlace(result));
                    passwordBox.setText("");

                } else {
                    GWT.log("Authorization failed");
                }
            }
        });
    }


}