/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "privilege", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nomprivilege"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
        @NamedQuery(name = "Privilege.findById", query = "SELECT p FROM Privilege p WHERE p.id = :id"),
        @NamedQuery(name = "Privilege.findByDescription", query = "SELECT p FROM Privilege p WHERE p.description = :description"),
        @NamedQuery(name = "Privilege.findByNomprivilege", query = "SELECT p FROM Privilege p WHERE p.nomprivilege = :nomprivilege")})
public class Privilege implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
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

    @XmlTransient
    public List<PersonnelPrivilege> getPersonnelPrivilegeList() {
        return personnelPrivilegeList;
    }

    public void setPersonnelPrivilegeList(List<PersonnelPrivilege> personnelPrivilegeList) {
        this.personnelPrivilegeList = personnelPrivilegeList;
    }

    @XmlTransient
    public List<Conflit> getConflitList() {
        return conflitList;
    }

    public void setConflitList(List<Conflit> conflitList) {
        this.conflitList = conflitList;
    }

    @XmlTransient
    public List<Conflit> getConflitList1() {
        return conflitList1;
    }

    public void setConflitList1(List<Conflit> conflitList1) {
        this.conflitList1 = conflitList1;
    }

    @XmlTransient
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

    @XmlTransient
    public List<RolePrivilege> getRolePrivilegeList() {
        return rolePrivilegeList;
    }

    public void setRolePrivilegeList(List<RolePrivilege> rolePrivilegeList) {
        this.rolePrivilegeList = rolePrivilegeList;
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
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Privilege[ id=" + id + " ]";
    }

}
