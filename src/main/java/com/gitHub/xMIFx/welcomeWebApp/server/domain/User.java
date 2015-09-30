package com.gitHub.xMIFx.welcomeWebApp.server.domain;

import com.gitHub.xMIFx.welcomeWebApp.server.util.Cryptographer;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Created by bukatinvv on 16.09.2015.
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    private Long id;
    private String login;
    private String password;
    private String name;

    public User() {
    }

    public User(final String login, final String name) {
        this.login = login;
        this.name = name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @Type(type = "long")
    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Column(name = "login", unique = true, nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(final String login) {
        this.login = login;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    private void setPassword(final String password) {
        this.password = password;
    }

    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void installHashPassword(final String password) throws NoSuchAlgorithmException, InvalidKeySpecException, UnsupportedEncodingException {
        this.password = Cryptographer.getCryptString(password);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        return !(id != null ? !id.equals(user.id) : user.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", login='" + login + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\''
                + '}';
    }
}
