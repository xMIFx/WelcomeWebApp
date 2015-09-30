package com.gitHub.xMIFx.welcomeWebApp.server.repositories;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;

import java.util.List;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public interface UserDAO {
    User getByLoginPassword(String login, String password);
}
