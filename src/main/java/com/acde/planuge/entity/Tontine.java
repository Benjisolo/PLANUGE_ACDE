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
@Table(name = "tontine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tontine.findAll", query = "SELECT t FROM Tontine t")
    , @NamedQuery(name = "Tontine.findById", query = "SELECT t FROM Tontine t WHERE t.id = :id")
    , @NamedQuery(name = "Tontine.findByC10", query = "SELECT t FROM Tontine t WHERE t.c10 = :c10")
    , @NamedQuery(name = "Tontine.findByC100", query = "SELECT t FROM Tontine t WHERE t.c100 = :c100")})
public class Tontine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "c10")
    private BigInteger c10;
    @Column(name = "c100")
    private BigInteger c100;

    public Tontine() {
    }

    public Tontine(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getC10() {
        return c10;
    }

    public void setC10(BigInteger c10) {
        this.c10 = c10;
    }

    public BigInteger getC100() {
        return c100;
    }

    public void setC100(BigInteger c100) {
        this.c100 = c100;
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
        if (!(object instanceof Tontine)) {
            return false;
        }
        Tontine other = (Tontine) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.Tontine[ id=" + id + " ]";
    }

}
