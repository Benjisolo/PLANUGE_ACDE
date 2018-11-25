/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author ►BenjiS☼l☼
 */
@Entity
@Table(name = "epargne")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Epargne.findAll", query = "SELECT e FROM Epargne e")
    , @NamedQuery(name = "Epargne.findById", query = "SELECT e FROM Epargne e WHERE e.id = :id")
    , @NamedQuery(name = "Epargne.findByAnnuelle", query = "SELECT e FROM Epargne e WHERE e.annuelle = :annuelle")
    , @NamedQuery(name = "Epargne.findByScolaire", query = "SELECT e FROM Epargne e WHERE e.scolaire = :scolaire")})
public class Epargne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "annuelle")
    private BigInteger annuelle;
    @Column(name = "scolaire")
    private BigInteger scolaire;

    public Epargne() {
    }

    public Epargne(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getAnnuelle() {
        return annuelle;
    }

    public void setAnnuelle(BigInteger annuelle) {
        this.annuelle = annuelle;
    }

    public BigInteger getScolaire() {
        return scolaire;
    }

    public void setScolaire(BigInteger scolaire) {
        this.scolaire = scolaire;
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
        if (!(object instanceof Epargne)) {
            return false;
        }
        Epargne other = (Epargne) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.Epargne[ id=" + id + " ]";
    }

}
