/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "type_charge", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"libelle"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TypeCharge.findAll", query = "SELECT t FROM TypeCharge t"),
        @NamedQuery(name = "TypeCharge.findById", query = "SELECT t FROM TypeCharge t WHERE t.id = :id"),
        @NamedQuery(name = "TypeCharge.findByLibelle", query = "SELECT t FROM TypeCharge t WHERE t.libelle = :libelle"),
        @NamedQuery(name = "TypeCharge.findByMontant", query = "SELECT t FROM TypeCharge t WHERE t.montant = :montant")})
public class TypeCharge extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "libelle", length = 255)
    private String libelle;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montant", precision = 17, scale = 17)
    private Double montant;
    @OneToMany(mappedBy = "typeCharge")
    private List<Charge> chargeList;

    public TypeCharge() {
    }

    public TypeCharge(Integer id) {
        this.id = id;
    }

    public TypeCharge(Integer id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }


    public List<Charge> getChargeList() {
        return chargeList;
    }

    public void setChargeList(List<Charge> chargeList) {
        this.chargeList = chargeList;
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
        if (!(object instanceof TypeCharge)) {
            return false;
        }
        TypeCharge other = (TypeCharge) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.TypeCharge[ id=" + id + " ]";
    }

}
