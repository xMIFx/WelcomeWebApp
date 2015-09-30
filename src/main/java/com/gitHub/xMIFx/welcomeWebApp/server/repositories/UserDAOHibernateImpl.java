package com.gitHub.xMIFx.welcomeWebApp.server.repositories;

import com.gitHub.xMIFx.welcomeWebApp.server.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bukatinvv on 16.09.2015.
 */
@Repository
public class UserDAOHibernateImpl implements UserDAO {
    @Autowired
    private SessionFactory factory;

    @Override
    public User getByLoginPassword(String login, String password) {
        User user = null;
        try (Session session = factory.openSession()) {
            user = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("login", login))
                    .add(Restrictions.eq("password", password))
                    .uniqueResult();
        }
        return user;
    }

}
