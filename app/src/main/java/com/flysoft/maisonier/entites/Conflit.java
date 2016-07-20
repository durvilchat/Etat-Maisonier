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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nono
 */
@Entity
@Table(name = "conflit", catalog = "maisonier", schema = "public")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Conflit.findAll", query = "SELECT c FROM Conflit c"),
        @NamedQuery(name = "Conflit.findById", query = "SELECT c FROM Conflit c WHERE c.id = :id")})
public class Conflit extends BaseModel {


    @PrimaryKey
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "privilege1", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege1;
    @JoinColumn(name = "privilege2", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Privilege privilege2;

    public Conflit() {
    }

    public Conflit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Privilege getPrivilege1() {
        return privilege1;
    }

    public void setPrivilege1(Privilege privilege1) {
        this.privilege1 = privilege1;
    }

    public Privilege getPrivilege2() {
        return privilege2;
    }

    public void setPrivilege2(Privilege privilege2) {
        this.privilege2 = privilege2;
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
        if (!(object instanceof Conflit)) {
            return false;
        }
        Conflit other = (Conflit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entites.Conflit[ id=" + id + " ]";
    }

}
