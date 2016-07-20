/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "remise", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"loyer"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Remise.findAll", query = "SELECT r FROM Remise r"),
        @NamedQuery(name = "Remise.findById", query = "SELECT r FROM Remise r WHERE r.id = :id"),
        @NamedQuery(name = "Remise.findByDateAttribution", query = "SELECT r FROM Remise r WHERE r.dateAttribution = :dateAttribution")})
public class Remise extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_attribution")
    @Temporal(TemporalType.DATE)
    private Date dateAttribution;
    @JoinColumn(name = "loyer", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Loyer loyer;
    @JoinColumn(name = "parametre", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Parametre parametre;

    public Remise() {
    }

    public Remise(Integer id) {
        this.id = id;
    }

    public Remise(Integer id, Date dateAttribution) {
        this.id = id;
        this.dateAttribution = dateAttribution;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(Date dateAttribution) {
        this.dateAttribution = dateAttribution;
    }

    public Loyer getLoyer() {
        return loyer;
    }

    public void setLoyer(Loyer loyer) {
        this.loyer = loyer;
    }

    public Parametre getParametre() {
        return parametre;
    }

    public void setParametre(Parametre parametre) {
        this.parametre = parametre;
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
        if (!(object instanceof Remise)) {
            return false;
        }
        Remise other = (Remise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Remise[ id=" + id + " ]";
    }

}
