package com.gitHub.xMIFx.welcomeWebApp.server.services;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.repositories.UserDAO;
import com.gitHub.xMIFx.welcomeWebApp.server.util.Cryptographer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bukatinvv on 16.09.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Long save(User user) {
        return userDAO.save(user);
    }

    @Override
    public User getByLoginPassword(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        return userDAO.getByLoginPassword(login, Cryptographer.getCryptString(password));
    }

    @Override
    public User getById(Long id) {
        return userDAO.getById(id);
    }

    @Override
    public boolean update(User user) {
        return userDAO.update(user);
    }

    @Override
    public boolean remove(User user) {
        return userDAO.remove(user);
    }
}
