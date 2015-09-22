package com.gitHub.xMIFx.welcomeWebApp.server.services;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.domain.WelcomeMessage;
import com.gitHub.xMIFx.welcomeWebApp.server.repositories.UserDAO;
import com.gitHub.xMIFx.welcomeWebApp.server.util.Cryptographer;
import com.gitHub.xMIFx.welcomeWebApp.server.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

/**
 * Created by bukatinvv on 16.09.2015.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final String nameProjectConfigFile = "project.properties";
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
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

    @Override
    public String getHelloMessageForUser(Locale currentLocale, User user) {
        LocalTime startTime = LocalTime.now();
        LOG.info("current locale: " + currentLocale);
        PropertiesReader properties = null;
        StringBuilder welcomeMessageForReturn = null;
        try {
            properties = new PropertiesReader(nameProjectConfigFile, currentLocale);

            List<WelcomeMessage> welcomeMessageList = properties.getWelcomeMessageList();
            LOG.info("Start to choose welcome message.");
            for (WelcomeMessage welcomeMessage : welcomeMessageList) {
                if (welcomeMessage.isTimeBetweenFromTo(startTime)) {
                    welcomeMessageForReturn = new StringBuilder();
                    welcomeMessageForReturn.append(welcomeMessage.getHelloMessage());
                    LOG.info("Selected messageObject is: " + welcomeMessage.toString());
                }
            }
        } catch (IOException e) {
            LOG.error("Error when read the properties " + nameProjectConfigFile, e);
        }
        if (welcomeMessageForReturn == null) {
            welcomeMessageForReturn = new StringBuilder();
            welcomeMessageForReturn.append("welcome");
        } else {
            welcomeMessageForReturn.append(", ")
                                   .append(user.getName())
                                   .append(".");
        }

        return welcomeMessageForReturn.toString();
    }
}
