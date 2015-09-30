package com.gitHub.xMIFx.welcomeWebApp.client.view.login;

import com.gitHub.xMIFx.welcomeWebApp.client.mvp.presenter.ILoginView;
import com.gitHub.xMIFx.welcomeWebApp.client.view.cssResources.MainResources;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.TextBox;


/**
 * LoginView for UiBinder
 * Created by Vlad on 19.09.2015.
 */
public class Login extends Composite implements ILoginView {

    private static LoginUiBinder ourUiBinder = GWT.create(LoginUiBinder.class);

    @UiField(provided = true)
    final MainResources res;

    @UiField
    TextBox loginBox;

    @UiField
    TextBox passwordBox;

    @UiField
    Button buttonSubmit;

    private Boolean loginTooShort = true;
    private Boolean passwordTooShort = true;

    private ILoginPresenter presenter;


    @UiTemplate("Login.ui.xml")
    interface LoginUiBinder extends UiBinder<HTMLPanel, Login> {
    }

    public Login() {
        this.res = GWT.create(MainResources.class);
        res.style().ensureInjected();
        initWidget(ourUiBinder.createAndBindUi(this));
    }

    @Override
    public void setPresenter(final ILoginPresenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void setTextToPasswordBox(final String password) {
        passwordBox.setText(password);
    }

    @UiHandler("loginBox")
    void handleLoginChange(final ValueChangeEvent<String> event) {
        if (event.getValue().length() < 1) {
            loginTooShort = true;
        } else {
            loginTooShort = false;
            GWT.log("Login is ok");
        }
    }

    @UiHandler("passwordBox")
    void handlePasswordChange(final ValueChangeEvent<String> event) {
        if (event.getValue().length() < 1) {
            passwordTooShort = true;
        } else {
            passwordTooShort = false;
            GWT.log("Password is ok");
        }
    }

    @UiHandler("buttonSubmit")
    void onClick(final ClickEvent e) {
        if (!passwordTooShort && !loginTooShort) {
            GWT.log("Start login");
            presenter.callServer(loginBox.getText()
                    , passwordBox.getText()
                    , LocaleInfo.getCurrentLocale().getLocaleName());
        } else {
            GWT.log("Login or password too short");
        }
    }
}