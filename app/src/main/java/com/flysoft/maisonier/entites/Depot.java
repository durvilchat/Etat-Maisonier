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
@Table(name = "depot", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Depot.findAll", query = "SELECT d FROM Depot d"),
        @NamedQuery(name = "Depot.findById", query = "SELECT d FROM Depot d WHERE d.id = :id"),
        @NamedQuery(name = "Depot.findByCompensation", query = "SELECT d FROM Depot d WHERE d.compensation = :compensation"),
        @NamedQuery(name = "Depot.findByDateDepot", query = "SELECT d FROM Depot d WHERE d.dateDepot = :dateDepot"),
        @NamedQuery(name = "Depot.findByMontant", query = "SELECT d FROM Depot d WHERE d.montant = :montant"),
        @NamedQuery(name = "Depot.findByObservation", query = "SELECT d FROM Depot d WHERE d.observation = :observation")})
public class Depot extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "compensation")
    private boolean compensation;

    @NotNull
    @Column(name = "date_depot")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDepot;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant", precision = 17, scale = 17)
    private Double montant;
    @Size(max = 255)
    @Column(name = "observation", length = 255)
    private String observation;
    @JoinColumn(name = "mois", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mois mois;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;

    public Depot() {
    }

    public Depot(Integer id) {
        this.id = id;
    }

    public Depot(Integer id, boolean compensation, Date dateDepot) {
        this.id = id;
        this.compensation = compensation;
        this.dateDepot = dateDepot;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getCompensation() {
        return compensation;
    }

    public void setCompensation(boolean compensation) {
        this.compensation = compensation;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public Mois getMois() {
        return mois;
    }

    public void setMois(Mois mois) {
        this.mois = mois;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
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
        if (!(object instanceof Depot)) {
            return false;
        }
        Depot other = (Depot) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Depot[ id=" + id + " ]";
    }

}
