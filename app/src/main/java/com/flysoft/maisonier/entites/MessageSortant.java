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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "message_sortant", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "MessageSortant.findAll", query = "SELECT m FROM MessageSortant m"),
        @NamedQuery(name = "MessageSortant.findById", query = "SELECT m FROM MessageSortant m WHERE m.id = :id"),
        @NamedQuery(name = "MessageSortant.findByContenu", query = "SELECT m FROM MessageSortant m WHERE m.contenu = :contenu"),
        @NamedQuery(name = "MessageSortant.findByTypeMessage", query = "SELECT m FROM MessageSortant m WHERE m.typeMessage = :typeMessage")})
public class MessageSortant extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "contenu", length = 255)
    private String contenu;
    @Size(max = 255)
    @Column(name = "type_message", length = 255)
    private String typeMessage;
    @OneToMany(mappedBy = "messageSortant")
    private List<BoiteEnvoi> boiteEnvoiList;

    public MessageSortant() {
    }

    public MessageSortant(Integer id) {
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

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }


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
        if (!(object instanceof MessageSortant)) {
            return false;
        }
        MessageSortant other = (MessageSortant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.MessageSortant[ id=" + id + " ]";
    }

}
