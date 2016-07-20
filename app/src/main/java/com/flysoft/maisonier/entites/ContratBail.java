/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "contrat_bail", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ContratBail.findAll", query = "SELECT c FROM ContratBail c"),
        @NamedQuery(name = "ContratBail.findById", query = "SELECT c FROM ContratBail c WHERE c.id = :id"),
        @NamedQuery(name = "ContratBail.findByDateEtablissement", query = "SELECT c FROM ContratBail c WHERE c.dateEtablissement = :dateEtablissement")})
public class ContratBail extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @NotNull
    @Column(name = "date_etablissement")
    @Temporal(TemporalType.DATE)
    private Date dateEtablissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratBail")
    private List<ContratRubrique> contratRubriqueList;
    @JoinColumn(name = "bailleur", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bailleur bailleur;
    @JoinColumn(name = "occupation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Occupation occupation;

    public ContratBail() {
    }

    public ContratBail(Integer id) {
        this.id = id;
    }

    public ContratBail(Integer id, Date dateEtablissement) {
        this.id = id;
        this.dateEtablissement = dateEtablissement;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateEtablissement() {
        return dateEtablissement;
    }

    public void setDateEtablissement(Date dateEtablissement) {
        this.dateEtablissement = dateEtablissement;
    }


    public List<ContratRubrique> getContratRubriqueList() {
        return contratRubriqueList;
    }

    public void setContratRubriqueList(List<ContratRubrique> contratRubriqueList) {
        this.contratRubriqueList = contratRubriqueList;
    }

    public Bailleur getBailleur() {
        return bailleur;
    }

    public void setBailleur(Bailleur bailleur) {
        this.bailleur = bailleur;
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
        if (!(object instanceof ContratBail)) {
            return false;
        }
        ContratBail other = (ContratBail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.ContratBail[ id=" + id + " ]";
    }

}
