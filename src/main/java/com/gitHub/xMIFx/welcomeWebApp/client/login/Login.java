package com.gitHub.xMIFx.welcomeWebApp.client.login;

import com.gitHub.xMIFx.welcomeWebApp.client.LoginServiceAsync;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Vlad on 19.09.2015.
 */
public class Login extends Composite {

    @UiField(provided = true)
    final LoginResources res;

    @UiField
    TextBox loginBox;

    @UiField
    TextBox passwordBox;

    @UiField
    Button buttonSubmit;

    @UiField
    Label errorBox;

    private final LoginServiceAsync loginServiceAsync;

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

    @UiHandler("buttonSubmit")
    void onClick(ClickEvent e) {
        sendInfoToServer();
    }

    private void sendInfoToServer() {
        loginServiceAsync.authorization(loginBox.getText(), passwordBox.getText(), new AsyncCallback<Boolean>() {
            @Override
            public void onFailure(Throwable caught) {
                errorBox.setText("error");
                GWT.log("error login service", caught);
            }

            @Override
            public void onSuccess(Boolean result) {
                if (result) {
                    errorBox.setText("true");
                } else {
                    errorBox.setText("false");
                }
            }
        });
    }


}