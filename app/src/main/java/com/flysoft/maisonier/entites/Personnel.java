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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "personnel", catalog = "maisonier", schema = "public", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"nom", "prenom"}),
        @UniqueConstraint(columnNames = {"matricule"})})
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
        @NamedQuery(name = "Personnel.findById", query = "SELECT p FROM Personnel p WHERE p.id = :id"),
        @NamedQuery(name = "Personnel.findByDateCreation", query = "SELECT p FROM Personnel p WHERE p.dateCreation = :dateCreation"),
        @NamedQuery(name = "Personnel.findByMatricule", query = "SELECT p FROM Personnel p WHERE p.matricule = :matricule"),
        @NamedQuery(name = "Personnel.findByNom", query = "SELECT p FROM Personnel p WHERE p.nom = :nom"),
        @NamedQuery(name = "Personnel.findByPhoto", query = "SELECT p FROM Personnel p WHERE p.photo = :photo"),
        @NamedQuery(name = "Personnel.findByPrenom", query = "SELECT p FROM Personnel p WHERE p.prenom = :prenom"),
        @NamedQuery(name = "Personnel.findByTheme", query = "SELECT p FROM Personnel p WHERE p.theme = :theme")})
public class Personnel extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Size(max = 254)
    @Column(name = "matricule", length = 254)
    private String matricule;
    @Size(max = 254)
    @Column(name = "nom", length = 254)
    private String nom;
    @Size(max = 255)
    @Column(name = "photo", length = 255)
    private String photo;
    @Size(max = 254)
    @Column(name = "prenom", length = 254)
    private String prenom;

    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "theme", length = 254)
    private String theme;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
    private List<PersonnelRole> personnelRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personnel")
    private List<PersonnelPrivilege> personnelPrivilegeList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "personnel")
    private CompteUtilisateur compteUtilisateur;
    @JoinColumn(name = "poste", referencedColumnName = "id")
    @ManyToOne
    private Poste poste;

    public Personnel() {
    }

    public Personnel(Integer id) {
        this.id = id;
    }

    public Personnel(Integer id, String theme) {
        this.id = id;
        this.theme = theme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }


    public List<PersonnelRole> getPersonnelRoleList() {
        return personnelRoleList;
    }

    public void setPersonnelRoleList(List<PersonnelRole> personnelRoleList) {
        this.personnelRoleList = personnelRoleList;
    }


    public List<PersonnelPrivilege> getPersonnelPrivilegeList() {
        return personnelPrivilegeList;
    }

    public void setPersonnelPrivilegeList(List<PersonnelPrivilege> personnelPrivilegeList) {
        this.personnelPrivilegeList = personnelPrivilegeList;
    }

    public CompteUtilisateur getCompteUtilisateur() {
        return compteUtilisateur;
    }

    public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
        this.compteUtilisateur = compteUtilisateur;
    }

    public Poste getPoste() {
        return poste;
    }

    public void setPoste(Poste poste) {
        this.poste = poste;
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
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Personnel[ id=" + id + " ]";
    }

}
