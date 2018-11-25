/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.models;

import com.acde.planuge.entity.Membres;

/**
 * @author Expression BenjiSolo is undefined on line 11, column 14 in Templates/Classes/Class.java.
 * @param <T>
 */
public class User<T> {
    private String login;
    private String password;
    private Membres currentMembre;

    public User() {
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

    public Membres getCurrentMembre() {
        return currentMembre;
    }

    public void setCurrentMembre(Membres currentMembre) {
        this.currentMembre = currentMembre;
    }

}
