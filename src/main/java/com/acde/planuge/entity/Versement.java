/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ►BenjiS☼l☼
 */
@Entity
@Table(name = "versement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Versement.findAll", query = "SELECT v FROM Versement v ORDER BY v.dateversement")
    , @NamedQuery(name = "Versement.findAllOfMembre", query = "SELECT v FROM Versement v WHERE v.idmembre = :membre")
    //, @NamedQuery(name = "Versement.findByMembreMoisType", query = "SELECT v FROM Versement WHWRE v.")
    , @NamedQuery(name = "Versement.findById", query = "SELECT v FROM Versement v WHERE v.id = :id")
    , @NamedQuery(name = "Versement.findByDateVersement", query = "SELECT v FROM Versement v WHERE v.dateversement = :date")})
public class Versement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne
    private TypeVersement type;
    @Column(name = "dateversement")
    @Temporal(TemporalType.DATE)
    private Date dateversement;
    @JoinColumn(name = "idmembre", referencedColumnName = "matricule")
    @ManyToOne
    private Membres idmembre;
    @Column(name = "montant")
    private BigInteger montant;
    
    public Versement() {
    }

    public Versement(Long id) {
        this.id = id;
    }

    public Versement(TypeVersement type, Date dateversement, Membres idmembre, BigInteger montant) {
        this.type = type;
        this.dateversement = dateversement;
        this.idmembre = idmembre;
        this.montant = montant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public TypeVersement getType() {
        return type;
    }

    public void setType(TypeVersement type) {
        this.type = type;
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
        if (!(object instanceof Versement)) {
            return false;
        }
        Versement other = (Versement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.Versement[ id=" + id + " ]";
    }

    public BigInteger getMontant() {
        return montant;
    }

    public void setMontant(BigInteger montant) {
        this.montant = montant;
    }

    public Date getDateversement() {
        return dateversement;
    }

    public void setDateversement(Date dateversement) {
        this.dateversement = dateversement;
    }

    public Membres getIdmembre() {
        return idmembre;
    }

    public void setIdmembre(Membres idmembre) {
        this.idmembre = idmembre;
    }

}
