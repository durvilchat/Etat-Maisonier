/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flysoft.maisonier.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "message_entrant", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MessageEntrant.findAll", query = "SELECT m FROM MessageEntrant m"),
        @NamedQuery(name = "MessageEntrant.findById", query = "SELECT m FROM MessageEntrant m WHERE m.id = :id"),
        @NamedQuery(name = "MessageEntrant.findByContenu", query = "SELECT m FROM MessageEntrant m WHERE m.contenu = :contenu"),
        @NamedQuery(name = "MessageEntrant.findByNumeroEmetteur", query = "SELECT m FROM MessageEntrant m WHERE m.numeroEmetteur = :numeroEmetteur")})
public class MessageEntrant extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "contenu", length = 255)
    private String contenu;
    @Size(max = 255)
    @Column(name = "numero_emetteur", length = 255)
    private String numeroEmetteur;
    @JoinColumn(name = "telephone", referencedColumnName = "id")
    @ManyToOne
    private Telephone telephone;

    public MessageEntrant() {
    }

    public MessageEntrant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public String getNumeroEmetteur() {
        return numeroEmetteur;
    }

    public void setNumeroEmetteur(String numeroEmetteur) {
        this.numeroEmetteur = numeroEmetteur;
    }

    public Telephone getTelephone() {
        return telephone;
    }

    public void setTelephone(Telephone telephone) {
        this.telephone = telephone;
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
        if (!(object instanceof MessageEntrant)) {
            return false;
        }
        MessageEntrant other = (MessageEntrant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.MessageEntrant[ id=" + id + " ]";
    }

}
