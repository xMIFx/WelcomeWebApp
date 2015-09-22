package com.gitHub.xMIFx.welcomeWebApp.server.services;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Locale;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public interface UserService {
    Long save(User user);

    User getByLoginPassword(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException;

    User getById(Long id);

    boolean update(User user);

    boolean remove(User user);

    String getHelloMessageForUser(Locale currentLocale, User user);

}
