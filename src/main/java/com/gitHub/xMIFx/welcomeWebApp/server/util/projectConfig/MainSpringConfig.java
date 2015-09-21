package com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig;

import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserServiceImpl;
import org.springframework.context.annotation.Bean;
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
                        , "com.gitHub.xMIFx.welcomeWebApp.server.services"
                        , "com.gitHub.xMIFx.welcomeWebApp.server.servlets"})
public class MainSpringConfig {
    @Bean(name = "userService")
    public UserService userService(){
        return new UserServiceImpl();
    }
}
