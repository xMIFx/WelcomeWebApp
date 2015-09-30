package com.gitHub.xMIFx.welcomeWebApp.server;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.WelcomeMessage;
import com.gitHub.xMIFx.welcomeWebApp.server.util.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.Locale;

/**
 * Created by Bukatin Vlad on 14.09.2015.
 */
public class App {
    private static final Logger LOG = LoggerFactory.getLogger(App.class);
    private static final String NAME_PROJECT_CONFIG_FILE = "project.properties";

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.now();
        LOG.info("Running app at: " + startTime);
        Locale currentLocale = Locale.getDefault();
        LOG.info("current locale: " + currentLocale);
        PropertiesReader properties = null;
        try {
            properties = new PropertiesReader(NAME_PROJECT_CONFIG_FILE,
                                    currentLocale);

            List<WelcomeMessage> welcomeMessageList = properties.getWelcomeMessageList();
            LOG.info("Start to choose welcome message.");
            for (WelcomeMessage welcomeMessage : welcomeMessageList) {
                if (welcomeMessage.isTimeBetweenFromTo(startTime)) {
                    System.out.println(welcomeMessage.getHelloMessage());
                    LOG.info("Selected messageObject is: " + welcomeMessage.toString());
                }
            }
        } catch (IOException e) {
            LOG.error("Error when read the properties " + NAME_PROJECT_CONFIG_FILE, e);
        }
        LOG.info("The End.");
    }

}
