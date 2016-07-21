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
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = Maisonier.class)
public class Rolle extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "etat")
    private boolean etat;
    @Size(max = 254)
    @Column(name = "nom", length = 254)
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolle")
    private List<PersonnelRole> personnelRoleList;
    @OneToMany(mappedBy = "rolle")
    private List<PersonnelPrivilege> personnelPrivilegeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rolle")
    private List<RolePrivilege> rolePrivilegeList;

    public Rolle() {
    }

    public Rolle(Integer id) {
        this.id = id;
    }

    public Rolle(Integer id, boolean etat) {
        this.id = id;
        this.etat = etat;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public List<PersonnelRole> getPersonnelRoleList() {
        return personnelRoleList;
    }

    public void setPersonnelRoleList(List<PersonnelRole> personnelRoleList) {
        this.personnelRoleList = personnelRoleList;
    }


    public List<PersonnelPrivilege> getPersonnelPrivilegeList() {
        return personnelPrivilegeList;
    }

    public void setPersonnelPrivilegeList(List<PersonnelPrivilege> personnelPrivilegeList) {
        this.personnelPrivilegeList = personnelPrivilegeList;
    }


    public List<RolePrivilege> getRolePrivilegeList() {
        return rolePrivilegeList;
    }

    public void setRolePrivilegeList(List<RolePrivilege> rolePrivilegeList) {
        this.rolePrivilegeList = rolePrivilegeList;
    }
}
