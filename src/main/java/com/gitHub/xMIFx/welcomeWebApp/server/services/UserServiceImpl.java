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
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String NAME_PROJECT_CONFIG_FILE = "project.properties";


    @Autowired
    private UserDAO userDAO;


    @Override
    public User getByLoginPassword(String login, String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        String hashPass = Cryptographer.getCryptString(password);
        User user = userDAO.getByLoginPassword(login, hashPass);
        return user;
    }

    @Override
    public String getHelloMessageForUser(Locale currentLocale, User user) {
        LocalTime startTime = LocalTime.now();
        LOG.info("current locale: " + currentLocale);
        PropertiesReader properties = null;
        StringBuilder welcomeMessageForReturn = new StringBuilder();
        try {
            properties = new PropertiesReader(NAME_PROJECT_CONFIG_FILE, currentLocale);

            List<WelcomeMessage> welcomeMessageList = properties.getWelcomeMessageList();
            LOG.info("Start to choose welcome message.");
            for (WelcomeMessage welcomeMessage : welcomeMessageList) {
                if (welcomeMessage.isTimeBetweenFromTo(startTime)) {
                    welcomeMessageForReturn.append(welcomeMessage.getHelloMessage());
                    LOG.info("Selected messageObject is: " + welcomeMessage.toString());
                }
            }
        } catch (IOException e) {
            LOG.error("Error when read the properties " + NAME_PROJECT_CONFIG_FILE, e);
        }
        if (welcomeMessageForReturn.length() == 0) {
            welcomeMessageForReturn.append("welcome");
        } else {
            welcomeMessageForReturn.append(", ")
                    .append(user.getName())
                    .append(".");
        }

        return welcomeMessageForReturn.toString();
    }
}
