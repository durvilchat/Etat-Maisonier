/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import android.support.annotation.Size;

import com.flysoft.maisonier.dataBase.Maisonier;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = Maisonier.class)
public class CompteUtilisateur extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "login", length = 254)
    private String login;
    @Size(max = 254)
    @Column(name = "password", length = 254)
    private String password;
    @JoinColumn(name = "personnel", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Personnel personnel;
    @OneToMany(mappedBy = "utilisateur")
    private List<Mouchard> mouchardList;

    public CompteUtilisateur() {
    }

    public CompteUtilisateur(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }


    public List<Mouchard> getMouchardList() {
        return mouchardList;
    }

    public void setMouchardList(List<Mouchard> mouchardList) {
        this.mouchardList = mouchardList;
    }



}
