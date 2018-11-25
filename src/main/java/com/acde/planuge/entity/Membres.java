/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author ►BenjiS☼l☼
 */
@Entity
@Table(name = "membres")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membres.findAll", query = "SELECT m FROM Membres m")
    , @NamedQuery(name = "Membres.findByMatricule", query = "SELECT m FROM Membres m WHERE m.matricule = :matricule")
    , @NamedQuery(name = "Membres.findByActiviteprofessionelle", query = "SELECT m FROM Membres m WHERE m.activiteprofessionelle = :activiteprofessionelle")
    , @NamedQuery(name = "Membres.findByAdresse", query = "SELECT m FROM Membres m WHERE m.adresse = :adresse")
    , @NamedQuery(name = "Membres.findByAdresseemployeur", query = "SELECT m FROM Membres m WHERE m.adresseemployeur = :adresseemployeur")
    , @NamedQuery(name = "Membres.findByDateadhesion", query = "SELECT m FROM Membres m WHERE m.dateadhesion = :dateadhesion")
    , @NamedQuery(name = "Membres.findByDatedelivrancecni", query = "SELECT m FROM Membres m WHERE m.datedelivrancecni = :datedelivrancecni")
    , @NamedQuery(name = "Membres.findByDatenaiss", query = "SELECT m FROM Membres m WHERE m.datenaiss = :datenaiss")
    , @NamedQuery(name = "Membres.findByEmail", query = "SELECT m FROM Membres m WHERE m.email = :email")
    , @NamedQuery(name = "Membres.findByFonction", query = "SELECT m FROM Membres m WHERE m.fonction = :fonction")
    , @NamedQuery(name = "Membres.findByLangue1", query = "SELECT m FROM Membres m WHERE m.langue1 = :langue1")
    , @NamedQuery(name = "Membres.findByLieuactiviteprof", query = "SELECT m FROM Membres m WHERE m.lieuactiviteprof = :lieuactiviteprof")
    , @NamedQuery(name = "Membres.findByLieuadhesion", query = "SELECT m FROM Membres m WHERE m.lieuadhesion = :lieuadhesion")
    , @NamedQuery(name = "Membres.findByLieudelivrancecni", query = "SELECT m FROM Membres m WHERE m.lieudelivrancecni = :lieudelivrancecni")
    , @NamedQuery(name = "Membres.findByLieuexercicefonction", query = "SELECT m FROM Membres m WHERE m.lieuexercicefonction = :lieuexercicefonction")
    , @NamedQuery(name = "Membres.findByLieunaiss", query = "SELECT m FROM Membres m WHERE m.lieunaiss = :lieunaiss")
    , @NamedQuery(name = "Membres.findByNom", query = "SELECT m FROM Membres m WHERE m.nom = :nom")
    , @NamedQuery(name = "Membres.findByNomconjoint", query = "SELECT m FROM Membres m WHERE m.nomconjoint = :nomconjoint")
    , @NamedQuery(name = "Membres.findByNomemployeur", query = "SELECT m FROM Membres m WHERE m.nomemployeur = :nomemployeur")
    , @NamedQuery(name = "Membres.findByNommere", query = "SELECT m FROM Membres m WHERE m.nommere = :nommere")
    , @NamedQuery(name = "Membres.findByNompere", query = "SELECT m FROM Membres m WHERE m.nompere = :nompere")
    , @NamedQuery(name = "Membres.findByNombreenfantlegitime", query = "SELECT m FROM Membres m WHERE m.nombreenfantlegitime = :nombreenfantlegitime")
    , @NamedQuery(name = "Membres.findByNombrepersonneacharge", query = "SELECT m FROM Membres m WHERE m.nombrepersonneacharge = :nombrepersonneacharge")
    , @NamedQuery(name = "Membres.findByNumcni", query = "SELECT m FROM Membres m WHERE m.numcni = :numcni")
    , @NamedQuery(name = "Membres.findByNumtel1", query = "SELECT m FROM Membres m WHERE m.numtel1 = :numtel1")
    , @NamedQuery(name = "Membres.findByNumtel2", query = "SELECT m FROM Membres m WHERE m.numtel2 = :numtel2")
    , @NamedQuery(name = "Membres.findByPwd", query = "SELECT m FROM Membres m WHERE m.pwd = :pwd")
    , @NamedQuery(name = "Membres.findByPrenom", query = "SELECT m FROM Membres m WHERE m.prenom = :prenom")
    , @NamedQuery(name = "Membres.findByRaisondadhesion", query = "SELECT m FROM Membres m WHERE m.raisondadhesion = :raisondadhesion")
    , @NamedQuery(name = "Membres.findByRegimematrimonial", query = "SELECT m FROM Membres m WHERE m.regimematrimonial = :regimematrimonial")
    , @NamedQuery(name = "Membres.findByResidencemere", query = "SELECT m FROM Membres m WHERE m.residencemere = :residencemere")
    , @NamedQuery(name = "Membres.findByResidencepere", query = "SELECT m FROM Membres m WHERE m.residencepere = :residencepere")
    , @NamedQuery(name = "Membres.findBySexe", query = "SELECT m FROM Membres m WHERE m.sexe = :sexe")
    , @NamedQuery(name = "Membres.findBySituationmatrimoniale", query = "SELECT m FROM Membres m WHERE m.situationmatrimoniale = :situationmatrimoniale")
    , @NamedQuery(name = "Membres.findByVilleresidence", query = "SELECT m FROM Membres m WHERE m.villeresidence = :villeresidence")})
public class Membres implements Serializable {

    @OneToMany(mappedBy = "idmembre")
    private List<Versement> versementList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "matricule")
    private String matricule;
    @Size(max = 255)
    @Column(name = "activiteprofessionelle")
    private String activiteprofessionelle;
    @Size(max = 255)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 255)
    @Column(name = "adresseemployeur")
    private String adresseemployeur;
    @Column(name = "dateadhesion")
    @Temporal(TemporalType.DATE)
    private Date dateadhesion;
    @Column(name = "datedelivrancecni")
    @Temporal(TemporalType.DATE)
    private Date datedelivrancecni;
    @Column(name = "datenaiss")
    @Temporal(TemporalType.DATE)
    private Date datenaiss;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 255)
    @Column(name = "email")
    private String email;
    @Size(max = 255)
    @Column(name = "fonction")
    private String fonction;
    @Size(max = 255)
    @Column(name = "langue1")
    private String langue1;
    @Size(max = 255)
    @Column(name = "lieuactiviteprof")
    private String lieuactiviteprof;
    @Size(max = 255)
    @Column(name = "lieuadhesion")
    private String lieuadhesion;
    @Size(max = 255)
    @Column(name = "lieudelivrancecni")
    private String lieudelivrancecni;
    @Size(max = 255)
    @Column(name = "lieuexercicefonction")
    private String lieuexercicefonction;
    @Size(max = 255)
    @Column(name = "lieunaiss")
    private String lieunaiss;
    @Size(max = 255)
    @Column(name = "nom")
    private String nom;
    @Size(max = 255)
    @Column(name = "nomconjoint")
    private String nomconjoint;
    @Size(max = 255)
    @Column(name = "nomemployeur")
    private String nomemployeur;
    @Size(max = 255)
    @Column(name = "nommere")
    private String nommere;
    @Size(max = 255)
    @Column(name = "nompere")
    private String nompere;
    @Column(name = "nombreenfantlegitime")
    private BigInteger nombreenfantlegitime;
    @Column(name = "nombrepersonneacharge")
    private BigInteger nombrepersonneacharge;
    @Column(name = "numcni")
    private BigInteger numcni;
    @Column(name = "numtel1")
    private BigInteger numtel1;
    @Column(name = "numtel2")
    private BigInteger numtel2;
    @Size(max = 255)
    @Column(name = "pwd")
    private String pwd;
    @Size(max = 255)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 255)
    @Column(name = "raisondadhesion")
    private String raisondadhesion;
    @Size(max = 255)
    @Column(name = "regimematrimonial")
    private String regimematrimonial;
    @Size(max = 255)
    @Column(name = "residencemere")
    private String residencemere;
    @Size(max = 255)
    @Column(name = "residencepere")
    private String residencepere;
    @Size(max = 255)
    @Column(name = "sexe")
    private String sexe;
    @Size(max = 255)
    @Column(name = "situationmatrimoniale")
    private String situationmatrimoniale;
    @Size(max = 255)
    @Column(name = "villeresidence")
    private String villeresidence;

    public Membres() {
    }

    public Membres(String matricule) {
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getActiviteprofessionelle() {
        return activiteprofessionelle;
    }

    public void setActiviteprofessionelle(String activiteprofessionelle) {
        this.activiteprofessionelle = activiteprofessionelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getAdresseemployeur() {
        return adresseemployeur;
    }

    public void setAdresseemployeur(String adresseemployeur) {
        this.adresseemployeur = adresseemployeur;
    }

    public Date getDateadhesion() {
        return dateadhesion;
    }

    public void setDateadhesion(Date dateadhesion) {
        this.dateadhesion = dateadhesion;
    }

    public Date getDatedelivrancecni() {
        return datedelivrancecni;
    }

    public void setDatedelivrancecni(Date datedelivrancecni) {
        this.datedelivrancecni = datedelivrancecni;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getLangue1() {
        return langue1;
    }

    public void setLangue1(String langue1) {
        this.langue1 = langue1;
    }

    public String getLieuactiviteprof() {
        return lieuactiviteprof;
    }

    public void setLieuactiviteprof(String lieuactiviteprof) {
        this.lieuactiviteprof = lieuactiviteprof;
    }

    public String getLieuadhesion() {
        return lieuadhesion;
    }

    public void setLieuadhesion(String lieuadhesion) {
        this.lieuadhesion = lieuadhesion;
    }

    public String getLieudelivrancecni() {
        return lieudelivrancecni;
    }

    public void setLieudelivrancecni(String lieudelivrancecni) {
        this.lieudelivrancecni = lieudelivrancecni;
    }

    public String getLieuexercicefonction() {
        return lieuexercicefonction;
    }

    public void setLieuexercicefonction(String lieuexercicefonction) {
        this.lieuexercicefonction = lieuexercicefonction;
    }

    public String getLieunaiss() {
        return lieunaiss;
    }

    public void setLieunaiss(String lieunaiss) {
        this.lieunaiss = lieunaiss;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNomconjoint() {
        return nomconjoint;
    }

    public void setNomconjoint(String nomconjoint) {
        this.nomconjoint = nomconjoint;
    }

    public String getNomemployeur() {
        return nomemployeur;
    }

    public void setNomemployeur(String nomemployeur) {
        this.nomemployeur = nomemployeur;
    }

    public String getNommere() {
        return nommere;
    }

    public void setNommere(String nommere) {
        this.nommere = nommere;
    }

    public String getNompere() {
        return nompere;
    }

    public void setNompere(String nompere) {
        this.nompere = nompere;
    }

    public BigInteger getNombreenfantlegitime() {
        return nombreenfantlegitime;
    }

    public void setNombreenfantlegitime(BigInteger nombreenfantlegitime) {
        this.nombreenfantlegitime = nombreenfantlegitime;
    }

    public BigInteger getNombrepersonneacharge() {
        return nombrepersonneacharge;
    }

    public void setNombrepersonneacharge(BigInteger nombrepersonneacharge) {
        this.nombrepersonneacharge = nombrepersonneacharge;
    }

    public BigInteger getNumcni() {
        return numcni;
    }

    public void setNumcni(BigInteger numcni) {
        this.numcni = numcni;
    }

    public BigInteger getNumtel1() {
        return numtel1;
    }

    public void setNumtel1(BigInteger numtel1) {
        this.numtel1 = numtel1;
    }

    public BigInteger getNumtel2() {
        return numtel2;
    }

    public void setNumtel2(BigInteger numtel2) {
        this.numtel2 = numtel2;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getRaisondadhesion() {
        return raisondadhesion;
    }

    public void setRaisondadhesion(String raisondadhesion) {
        this.raisondadhesion = raisondadhesion;
    }

    public String getRegimematrimonial() {
        return regimematrimonial;
    }

    public void setRegimematrimonial(String regimematrimonial) {
        this.regimematrimonial = regimematrimonial;
    }

    public String getResidencemere() {
        return residencemere;
    }

    public void setResidencemere(String residencemere) {
        this.residencemere = residencemere;
    }

    public String getResidencepere() {
        return residencepere;
    }

    public void setResidencepere(String residencepere) {
        this.residencepere = residencepere;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getSituationmatrimoniale() {
        return situationmatrimoniale;
    }

    public void setSituationmatrimoniale(String situationmatrimoniale) {
        this.situationmatrimoniale = situationmatrimoniale;
    }

    public String getVilleresidence() {
        return villeresidence;
    }

    public void setVilleresidence(String villeresidence) {
        this.villeresidence = villeresidence;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricule != null ? matricule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membres)) {
            return false;
        }
        Membres other = (Membres) object;
        if ((this.matricule == null && other.matricule != null) || (this.matricule != null && !this.matricule.equals(other.matricule))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.acde.planuge.entity.Membres[ matricule=" + matricule + " ]";
    }

    @XmlTransient
    public List<Versement> getVersementList() {
        return versementList;
    }

    public void setVersementList(List<Versement> versementList) {
        this.versementList = versementList;
    }

}
