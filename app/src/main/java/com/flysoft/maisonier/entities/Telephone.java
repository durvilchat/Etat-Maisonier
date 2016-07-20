/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author nono
 */
@Entity
@Table(name = "telephone", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Telephone.findAll", query = "SELECT t FROM Telephone t"),
        @NamedQuery(name = "Telephone.findById", query = "SELECT t FROM Telephone t WHERE t.id = :id"),
        @NamedQuery(name = "Telephone.findByFrequence", query = "SELECT t FROM Telephone t WHERE t.frequence = :frequence"),
        @NamedQuery(name = "Telephone.findByMarque", query = "SELECT t FROM Telephone t WHERE t.marque = :marque"),
        @NamedQuery(name = "Telephone.findByModele", query = "SELECT t FROM Telephone t WHERE t.modele = :modele"),
        @NamedQuery(name = "Telephone.findByNumeroTelephone", query = "SELECT t FROM Telephone t WHERE t.numeroTelephone = :numeroTelephone"),
        @NamedQuery(name = "Telephone.findByPort", query = "SELECT t FROM Telephone t WHERE t.port = :port"),
        @NamedQuery(name = "Telephone.findByServerNumber", query = "SELECT t FROM Telephone t WHERE t.serverNumber = :serverNumber"),
        @NamedQuery(name = "Telephone.findByTypeReseau", query = "SELECT t FROM Telephone t WHERE t.typeReseau = :typeReseau")})
public class Telephone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "frequence", nullable = false)
    private int frequence;
    @Size(max = 255)
    @Column(name = "marque", length = 255)
    private String marque;
    @Size(max = 255)
    @Column(name = "modele", length = 255)
    private String modele;
    @Size(max = 255)
    @Column(name = "numero_telephone", length = 255)
    private String numeroTelephone;
    @Size(max = 255)
    @Column(name = "port", length = 255)
    private String port;
    @Size(max = 255)
    @Column(name = "server_number", length = 255)
    private String serverNumber;
    @Size(max = 255)
    @Column(name = "type_reseau", length = 255)
    private String typeReseau;
    @OneToMany(mappedBy = "telephone")
    private List<MessageEntrant> messageEntrantList;
    @OneToMany(mappedBy = "telephone")
    private List<BoiteEnvoi> boiteEnvoiList;

    public Telephone() {
    }

    public Telephone(Integer id) {
        this.id = id;
    }

    public Telephone(Integer id, int frequence) {
        this.id = id;
        this.frequence = frequence;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServerNumber() {
        return serverNumber;
    }

    public void setServerNumber(String serverNumber) {
        this.serverNumber = serverNumber;
    }

    public String getTypeReseau() {
        return typeReseau;
    }

    public void setTypeReseau(String typeReseau) {
        this.typeReseau = typeReseau;
    }

    @XmlTransient
    public List<MessageEntrant> getMessageEntrantList() {
        return messageEntrantList;
    }

    public void setMessageEntrantList(List<MessageEntrant> messageEntrantList) {
        this.messageEntrantList = messageEntrantList;
    }

    @XmlTransient
    public List<BoiteEnvoi> getBoiteEnvoiList() {
        return boiteEnvoiList;
    }

    public void setBoiteEnvoiList(List<BoiteEnvoi> boiteEnvoiList) {
        this.boiteEnvoiList = boiteEnvoiList;
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
        if (!(object instanceof Telephone)) {
            return false;
        }
        Telephone other = (Telephone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Telephone[ id=" + id + " ]";
    }

}
