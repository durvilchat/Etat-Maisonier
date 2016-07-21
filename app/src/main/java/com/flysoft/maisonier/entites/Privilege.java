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
public class Privilege extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;
    @Size(max = 254)
    @Column(name = "nomprivilege", length = 254)
    private String nomprivilege;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege")
    private List<PersonnelPrivilege> personnelPrivilegeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege1")
    private List<Conflit> conflitList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege2")
    private List<Conflit> conflitList1;
    @OneToMany(mappedBy = "hierarchie")
    private List<Privilege> privilegeList;
    @JoinColumn(name = "hierarchie", referencedColumnName = "id")
    @ManyToOne
    private Privilege hierarchie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "privilege")
    private List<RolePrivilege> rolePrivilegeList;

    public Privilege() {
    }

    public Privilege(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomprivilege() {
        return nomprivilege;
    }

    public void setNomprivilege(String nomprivilege) {
        this.nomprivilege = nomprivilege;
    }


    public List<PersonnelPrivilege> getPersonnelPrivilegeList() {
        return personnelPrivilegeList;
    }

    public void setPersonnelPrivilegeList(List<PersonnelPrivilege> personnelPrivilegeList) {
        this.personnelPrivilegeList = personnelPrivilegeList;
    }


    public List<Conflit> getConflitList() {
        return conflitList;
    }

    public void setConflitList(List<Conflit> conflitList) {
        this.conflitList = conflitList;
    }


    public List<Conflit> getConflitList1() {
        return conflitList1;
    }

    public void setConflitList1(List<Conflit> conflitList1) {
        this.conflitList1 = conflitList1;
    }


    public List<Privilege> getPrivilegeList() {
        return privilegeList;
    }

    public void setPrivilegeList(List<Privilege> privilegeList) {
        this.privilegeList = privilegeList;
    }

    public Privilege getHierarchie() {
        return hierarchie;
    }

    public void setHierarchie(Privilege hierarchie) {
        this.hierarchie = hierarchie;
    }


    public List<RolePrivilege> getRolePrivilegeList() {
        return rolePrivilegeList;
    }

    public void setRolePrivilegeList(List<RolePrivilege> rolePrivilegeList) {
        this.rolePrivilegeList = rolePrivilegeList;
    }
}
