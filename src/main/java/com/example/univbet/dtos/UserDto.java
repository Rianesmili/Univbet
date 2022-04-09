package com.example.univbet.dtos;


import com.example.univbet.ejbs.User;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;

@Named("user")
@SessionScoped
public class UserDto implements Serializable {
    @EJB
    private User userBean;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private boolean connected;
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String doLogin() {
        if (this.login.equals("Admin") && this.password.equals("Ch4ng3_1t_N0w")) {
            this.role="Admin";
        }
            for (UserDto user : getUsers()) {
            if (user.login == this.login && user.getPassword() == this.password) {
                this.role="User";
                this.connected = true;
            }
        }
        return "test";
    }

    public String doInsert() {
        this.userBean.doInsert(this.getLogin(), this.getNom(), this.getPrenom(), this.getPassword());
        return "test";
    }
    public List<UserDto> getUsers() {
        return this.userBean.getUsers();
    }
}