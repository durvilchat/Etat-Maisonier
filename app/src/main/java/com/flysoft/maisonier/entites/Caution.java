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
@Table(name = "caution", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Caution.findAll", query = "SELECT c FROM Caution c"),
        @NamedQuery(name = "Caution.findById", query = "SELECT c FROM Caution c WHERE c.id = :id"),
        @NamedQuery(name = "Caution.findByDateDepot", query = "SELECT c FROM Caution c WHERE c.dateDepot = :dateDepot"),
        @NamedQuery(name = "Caution.findByMontant", query = "SELECT c FROM Caution c WHERE c.montant = :montant"),
        @NamedQuery(name = "Caution.findByMontantRembourse", query = "SELECT c FROM Caution c WHERE c.montantRembourse = :montantRembourse"),
        @NamedQuery(name = "Caution.findByStatut", query = "SELECT c FROM Caution c WHERE c.statut = :statut")})
public class Caution extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_depot")
    @Temporal(TemporalType.DATE)
    private Date dateDepot;

    @NotNull
    @Column(name = "montant")
    private double montant;

    @NotNull
    @Column(name = "montant_rembourse")
    private double montantRembourse;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "statut", length = 255)
    private String statut;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;
    @JoinColumn(name = "type_caution", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private TypeCaution typeCaution;

    public Caution() {
    }

    public Caution(Integer id) {
        this.id = id;
    }

    public Caution(Integer id, Date dateDepot, double montant, double montantRembourse, String statut) {
        this.id = id;
        this.dateDepot = dateDepot;
        this.montant = montant;
        this.montantRembourse = montantRembourse;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantRembourse() {
        return montantRembourse;
    }

    public void setMontantRembourse(double montantRembourse) {
        this.montantRembourse = montantRembourse;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public TypeCaution getTypeCaution() {
        return typeCaution;
    }

    public void setTypeCaution(TypeCaution typeCaution) {
        this.typeCaution = typeCaution;
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
        if (!(object instanceof Caution)) {
            return false;
        }
        Caution other = (Caution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Caution[ id=" + id + " ]";
    }

}
