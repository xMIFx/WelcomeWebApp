package com.gitHub.xMIFx.welcomeWebApp.server;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserService;
import com.gitHub.xMIFx.welcomeWebApp.server.services.UserServiceImpl;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.DataBaseConfig;
import com.gitHub.xMIFx.welcomeWebApp.server.util.projectConfig.MainSpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bukatinvv on 16.09.2015.
 */
public class TestApp {

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeySpecException {
        AnnotationConfigApplicationContext  ctx =
                new AnnotationConfigApplicationContext();
        ctx.register(MainSpringConfig.class);
        ctx.register(DataBaseConfig.class);
        ctx.refresh();
        ctx.start();
        UserService userService = ctx.getBean(UserServiceImpl.class);
        User user = new User("i","i");
        user.installHashPassword("smith");
        System.out.println(userService.save(user));
        System.out.println(user.getPassword());
        System.out.println(userService.getById(1L));
        System.out.println(userService.getById(2L));
    }
}
