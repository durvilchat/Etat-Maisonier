/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "serveur_mail", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"hote"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ServeurMail.findAll", query = "SELECT s FROM ServeurMail s"),
        @NamedQuery(name = "ServeurMail.findById", query = "SELECT s FROM ServeurMail s WHERE s.id = :id"),
        @NamedQuery(name = "ServeurMail.findByHote", query = "SELECT s FROM ServeurMail s WHERE s.hote = :hote"),
        @NamedQuery(name = "ServeurMail.findByNom", query = "SELECT s FROM ServeurMail s WHERE s.nom = :nom")})
public class ServeurMail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "hote", length = 255)
    private String hote;
    @Size(max = 255)
    @Column(name = "nom", length = 255)
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serveurMail")
    private List<AdresseMail> adresseMailList;

    public ServeurMail() {
    }

    public ServeurMail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHote() {
        return hote;
    }

    public void setHote(String hote) {
        this.hote = hote;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public List<AdresseMail> getAdresseMailList() {
        return adresseMailList;
    }

    public void setAdresseMailList(List<AdresseMail> adresseMailList) {
        this.adresseMailList = adresseMailList;
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
        if (!(object instanceof ServeurMail)) {
            return false;
        }
        ServeurMail other = (ServeurMail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ServeurMail[ id=" + id + " ]";
    }

}
