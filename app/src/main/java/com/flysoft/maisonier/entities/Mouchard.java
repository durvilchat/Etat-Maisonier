/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "mouchard", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Mouchard.findAll", query = "SELECT m FROM Mouchard m"),
        @NamedQuery(name = "Mouchard.findById", query = "SELECT m FROM Mouchard m WHERE m.id = :id"),
        @NamedQuery(name = "Mouchard.findByAction", query = "SELECT m FROM Mouchard m WHERE m.action = :action"),
        @NamedQuery(name = "Mouchard.findByDateAction", query = "SELECT m FROM Mouchard m WHERE m.dateAction = :dateAction")})
public class Mouchard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "action", nullable = false, length = 255)
    private String action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_action", nullable = false)
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mouchard)) {
            return false;
        }
        Mouchard other = (Mouchard) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Mouchard[ id=" + id + " ]";
    }

}
