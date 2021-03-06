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
public class PersonnelPrivilege extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_attrib")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAttrib;
    @Column(name = "date_retrait")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetrait;
    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @JoinColumn(name = "personnel", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Personnel personnel;
    @JoinColumn(name = "privilege", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege;
    @JoinColumn(name = "rolle", referencedColumnName = "id")
    @ManyToOne
    private Rolle rolle;

    public PersonnelPrivilege() {
    }

    public PersonnelPrivilege(Integer id) {
        this.id = id;
    }

    public PersonnelPrivilege(Integer id, Date dateAttrib, boolean etat) {
        this.id = id;
        this.dateAttrib = dateAttrib;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAttrib() {
        return dateAttrib;
    }

    public void setDateAttrib(Date dateAttrib) {
        this.dateAttrib = dateAttrib;
    }

    public Date getDateRetrait() {
        return dateRetrait;
    }

    public void setDateRetrait(Date dateRetrait) {
        this.dateRetrait = dateRetrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public Rolle getRolle() {
        return rolle;
    }

    public void setRolle(Rolle rolle) {
        this.rolle = rolle;
    }
}
