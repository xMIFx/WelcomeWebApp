package com.gitHub.xMIFx.welcomeWebApp.server.repositories;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;

import java.util.List;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public interface UserDAO {

    Long save(User user);

    User getByLoginPassword(String login, String password);

    User getById(Long id);

    List<User> getAll();

    boolean update(User user);

    boolean remove(User user);
}
