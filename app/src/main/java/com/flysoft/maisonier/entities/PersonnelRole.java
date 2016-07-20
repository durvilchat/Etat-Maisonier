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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "personnel_role", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "PersonnelRole.findAll", query = "SELECT p FROM PersonnelRole p"),
        @NamedQuery(name = "PersonnelRole.findById", query = "SELECT p FROM PersonnelRole p WHERE p.id = :id"),
        @NamedQuery(name = "PersonnelRole.findByDateAttrib", query = "SELECT p FROM PersonnelRole p WHERE p.dateAttrib = :dateAttrib"),
        @NamedQuery(name = "PersonnelRole.findByDateRetrait", query = "SELECT p FROM PersonnelRole p WHERE p.dateRetrait = :dateRetrait"),
        @NamedQuery(name = "PersonnelRole.findByEtat", query = "SELECT p FROM PersonnelRole p WHERE p.etat = :etat")})
public class PersonnelRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_attrib", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAttrib;
    @Column(name = "date_retrait")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetrait;
    @Basic(optional = false)
    @NotNull
    @Column(name = "etat", nullable = false)
    private boolean etat;
    @JoinColumn(name = "personnel", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Personnel personnel;
    @JoinColumn(name = "rolle", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Rolle rolle;

    public PersonnelRole() {
    }

    public PersonnelRole(Integer id) {
        this.id = id;
    }

    public PersonnelRole(Integer id, Date dateAttrib, boolean etat) {
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
        if (!(object instanceof PersonnelRole)) {
            return false;
        }
        PersonnelRole other = (PersonnelRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.PersonnelRole[ id=" + id + " ]";
    }

}
