/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "role_privilege", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "RolePrivilege.findAll", query = "SELECT r FROM RolePrivilege r"),
        @NamedQuery(name = "RolePrivilege.findById", query = "SELECT r FROM RolePrivilege r WHERE r.id = :id")})
public class RolePrivilege extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "privilege", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege;
    @JoinColumn(name = "rolle", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Rolle rolle;

    public RolePrivilege() {
    }

    public RolePrivilege(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePrivilege)) {
            return false;
        }
        RolePrivilege other = (RolePrivilege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.RolePrivilege[ id=" + id + " ]";
    }

}
