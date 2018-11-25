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
@Table(name = "sanction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sanction.findAll", query = "SELECT s FROM Sanction s")
    , @NamedQuery(name = "Sanction.findById", query = "SELECT s FROM Sanction s WHERE s.id = :id")
    , @NamedQuery(name = "Sanction.findByAbsence", query = "SELECT s FROM Sanction s WHERE s.absence = :absence")
    , @NamedQuery(name = "Sanction.findByRetard", query = "SELECT s FROM Sanction s WHERE s.retard = :retard")
    , @NamedQuery(name = "Sanction.findByTontine", query = "SELECT s FROM Sanction s WHERE s.tontine = :tontine")})
public class Sanction implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "absence")
    private BigInteger absence;
    @Column(name = "retard")
    private BigInteger retard;
    @Column(name = "tontine")
    private BigInteger tontine;

    public Sanction() {
    }

    public Sanction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getAbsence() {
        return absence;
    }

    public void setAbsence(BigInteger absence) {
        this.absence = absence;
    }

    public BigInteger getRetard() {
        return retard;
    }

    public void setRetard(BigInteger retard) {
        this.retard = retard;
    }

    public BigInteger getTontine() {
        return tontine;
    }

    public void setTontine(BigInteger tontine) {
        this.tontine = tontine;
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
        if (!(object instanceof Sanction)) {
            return false;
        }
        Sanction other = (Sanction) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.Sanction[ id=" + id + " ]";
    }

}
