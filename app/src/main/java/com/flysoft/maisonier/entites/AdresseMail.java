/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.NotNull;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = Maisonier.class)
public class AdresseMail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mail", length = 255)
    private String mail;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", length = 255)
    private String password;
    @JoinColumn(name = "serveur_mail", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ServeurMail serveurMail;

    public AdresseMail() {
    }

    public AdresseMail(Integer id) {
        this.id = id;
    }

    public AdresseMail(Integer id, String mail, String password) {
        this.id = id;
        this.mail = mail;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServeurMail getServeurMail() {
        return serveurMail;
    }

    public void setServeurMail(ServeurMail serveurMail) {
        this.serveurMail = serveurMail;
    }


}
