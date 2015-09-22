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

   /* {
        try {
            User user1 = new User("john", "John");
            user1.installHashPassword("smith");
            save(user1);

            User user2 = new User("ivan", "Иван");
            user2.installHashPassword("secret");
            save(user2);
        } catch (Throwable t) {
        }
    }*/

    @Transactional
    @Override
    public Long save(User user) {
        Session session = factory.getCurrentSession();
        session.save(user);
        return user.getId();
    }


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

    @Override
    public User getById(Long id) {
        User user = null;
        try (Session session = factory.openSession()) {
            user = (User) session.createCriteria(User.class)
                    .add(Restrictions.eq("id", id))
                    .uniqueResult();
        }
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> personList = new ArrayList<>();
        try (Session session = factory.openSession()) {
            personList = (List<User>) session.createCriteria(User.class).list();
        }
        return personList;
    }

    @Transactional
    @Override
    public boolean update(User user) {
        Session session = factory.getCurrentSession();
        session.update(user);
        return true;
    }

    @Transactional
    @Override
    public boolean remove(User user) {
        Session session = factory.getCurrentSession();
        session.delete(user);
        return true;
    }
}
