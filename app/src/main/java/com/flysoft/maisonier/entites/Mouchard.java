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

import java.util.Date;

@Table(database = Maisonier.class)
public class Mouchard extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "action", length = 255)
    private String action;

    @NotNull
    @Column(name = "date_action")
    @Temporal(TemporalType.TIME)
    private Date dateAction;
    @JoinColumn(name = "utilisateur", referencedColumnName = "id")
    @ManyToOne
    private CompteUtilisateur utilisateur;

    public Mouchard() {
    }

    public Mouchard(Integer id) {
        this.id = id;
    }

    public Mouchard(Integer id, String action, Date dateAction) {
        this.id = id;
        this.action = action;
        this.dateAction = dateAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Date getDateAction() {
        return dateAction;
    }

    public void setDateAction(Date dateAction) {
        this.dateAction = dateAction;
    }

    public CompteUtilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(CompteUtilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

}
