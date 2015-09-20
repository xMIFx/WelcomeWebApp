package com.gitHub.xMIFx.welcomeWebApp.server.util;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.WelcomeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalTime;
import java.util.*;

/**
 * Created by Bukatin Vlad on 14.09.2015.
 */
public class PropertiesReader {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesReader.class);

    private final String nameProjectConfigFile;
    private List<WelcomeMessage> welcomeMessageList;


    public PropertiesReader(String propertiesName, Locale locale) throws IOException {
        this.nameProjectConfigFile = propertiesName;
        init(locale);

    }

    private void init(Locale locale) throws IOException {
        LOG.info("start read from " + this.nameProjectConfigFile);
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream in = loader.getResourceAsStream(this.nameProjectConfigFile)) {
            prop.load(in);
            int numberOfWelcomeMessages = Integer.parseInt(prop.getProperty("numberOfWelcomeMessages"));
            LOG.info("number of different welcome messages: " + numberOfWelcomeMessages);
            welcomeMessageList = new ArrayList<>(numberOfWelcomeMessages);
            for (int i = 1; i <= numberOfWelcomeMessages; i++) {
                LOG.info("begin create " + i + " of " + numberOfWelcomeMessages + " different welcome messages");
                String propertyObjectName = "welcomeObj" + i;
                LocalTime from = LocalTime.of(
                        Integer.parseInt(prop.getProperty(propertyObjectName + ".from.hh"))
                        , Integer.parseInt(prop.getProperty(propertyObjectName + ".from.MM")));
                LocalTime to = LocalTime.of(
                        Integer.parseInt(prop.getProperty(propertyObjectName + ".to.hh"))
                        , Integer.parseInt(prop.getProperty(propertyObjectName + ".to.MM")));
                WelcomeMessage welcomeMessage = new WelcomeMessage(from, to);
                setStringMessageWithLocalization(welcomeMessage, propertyObjectName, locale);
                welcomeMessageList.add(welcomeMessage);
                LOG.info("finish create " + i + " of " + numberOfWelcomeMessages + " different welcome messages and add to list");
                if (LOG.isTraceEnabled()) {
                    LOG.trace(welcomeMessage.toString());
                }
            }
        }
        if (LOG.isTraceEnabled()) {
            LOG.trace("result of reading: " + welcomeMessageList.toString());
        }
        LOG.info("finish read from: " + this.nameProjectConfigFile);
    }

    public List<WelcomeMessage> getWelcomeMessageList() {
        return welcomeMessageList;
    }

    public static void setStringMessageWithLocalization(WelcomeMessage welcomeMessage, String resourceObjName, Locale locale) {
        if (LOG.isTraceEnabled()) {
            LOG.trace("Start setting message in: " + resourceObjName);
        }
        Locale defLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
        ResourceBundle bundle = ResourceBundle.getBundle("i18n/welcomeMessage", locale);
        String message = bundle.getString(resourceObjName + ".welcomeMessage");
        Locale.setDefault(defLocale);
        if (LOG.isTraceEnabled()) {
            LOG.trace("set the message :" + message + " to: " + resourceObjName);
        }
        welcomeMessage.setHelloMessage(message);
        if (LOG.isTraceEnabled()) {
            LOG.trace("Finish setting message in: " + resourceObjName);
        }
    }
}
