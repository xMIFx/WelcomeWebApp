package com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by bukatinvv on 16.09.2015.
 */

@Configuration
@Import(DataBaseConfig.class)
@EnableTransactionManagement
@ComponentScan(value = {"com.gitHub.xMIFx.welcomeWebApp.server.repositories"
                        , "com.gitHub.xMIFx.welcomeWebApp.server.services"})
public class MainSpringConfig {
}
