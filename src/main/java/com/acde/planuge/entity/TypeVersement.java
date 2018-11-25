/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
 * @author ►BenjiS☼l☼
 */
@Entity
@Table(name = "type_versement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeVersement.findAll", query = "SELECT t FROM TypeVersement t")
    , @NamedQuery(name = "TypeVersement.findById", query = "SELECT t FROM TypeVersement t WHERE t.id = :id")
    , @NamedQuery(name = "TypeVersement.findByLabel", query = "SELECT t FROM TypeVersement t WHERE t.label = :label")})
public class TypeVersement implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "id")
    private String id;
    @Size(max = 2147483647)
    @Column(name = "label")
    private String label;
    @OneToMany(mappedBy = "type")
    private List<Versement> versementList;

    public TypeVersement() {
    }

    public TypeVersement(String id, String label) {
        this.id = id;
        this.label = label;
    }

    public TypeVersement(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @XmlTransient
    public List<Versement> getVersementList() {
        return versementList;
    }

    public void setVersementList(List<Versement> versementList) {
        this.versementList = versementList;
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
        if (!(object instanceof TypeVersement)) {
            return false;
        }
        TypeVersement other = (TypeVersement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.TypeVersement[ id=" + id + " ]";
    }

}
