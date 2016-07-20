/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "adresse_mail", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "AdresseMail.findAll", query = "SELECT a FROM AdresseMail a"),
        @NamedQuery(name = "AdresseMail.findById", query = "SELECT a FROM AdresseMail a WHERE a.id = :id"),
        @NamedQuery(name = "AdresseMail.findByMail", query = "SELECT a FROM AdresseMail a WHERE a.mail = :mail"),
        @NamedQuery(name = "AdresseMail.findByPassword", query = "SELECT a FROM AdresseMail a WHERE a.password = :password")})
public class AdresseMail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "mail", nullable = false, length = 255)
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    @JoinColumn(name = "serveur_mail", referencedColumnName = "id", nullable = false)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdresseMail)) {
            return false;
        }
        AdresseMail other = (AdresseMail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.AdresseMail[ id=" + id + " ]";
    }

}
