/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "compte_utilisateur", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"login", "password"}),
        @UniqueConstraint(columnNames = {"personnel"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "CompteUtilisateur.findAll", query = "SELECT c FROM CompteUtilisateur c"),
        @NamedQuery(name = "CompteUtilisateur.findById", query = "SELECT c FROM CompteUtilisateur c WHERE c.id = :id"),
        @NamedQuery(name = "CompteUtilisateur.findByLogin", query = "SELECT c FROM CompteUtilisateur c WHERE c.login = :login"),
        @NamedQuery(name = "CompteUtilisateur.findByPassword", query = "SELECT c FROM CompteUtilisateur c WHERE c.password = :password")})
public class CompteUtilisateur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Size(max = 254)
    @Column(name = "login", length = 254)
    private String login;
    @Size(max = 254)
    @Column(name = "password", length = 254)
    private String password;
    @JoinColumn(name = "personnel", referencedColumnName = "id", nullable = false)
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

    @XmlTransient
    public List<Mouchard> getMouchardList() {
        return mouchardList;
    }

    public void setMouchardList(List<Mouchard> mouchardList) {
        this.mouchardList = mouchardList;
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
        if (!(object instanceof CompteUtilisateur)) {
            return false;
        }
        CompteUtilisateur other = (CompteUtilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.CompteUtilisateur[ id=" + id + " ]";
    }

}
