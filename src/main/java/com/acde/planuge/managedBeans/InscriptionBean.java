/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.managedBeans;

import com.acde.planuge.entity.Membres;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author ►BenjiS☼l☼
 */

@ManagedBean(name="inscriptionBean")
@SessionScoped
public class InscriptionBean implements Serializable {
    @PersistenceContext(unitName = "planugeAcdePU")
    EntityManager em;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Membres membre;
    private boolean submitted;
    private String mat, pass, dateNaiss, sexe, dateAdhesion, dateDelivranceCni;

    public InscriptionBean() {
        this.membre = new Membres();
        this.submitted = false;
        this.sexe = "Homme";
    }

    public String valider() throws ParseException, NamingException, NotSupportedException, RollbackException, SystemException, HeuristicMixedException, HeuristicRollbackException {
        if (!submitted) {
            //set sexe
            if(this.sexe.equals("Femme"))
                membre.setSexe("F");
            else
                membre.setSexe("M");
            //set datenaiss
            try {
                membre.setDatenaiss(dateFormat.parse(this.dateNaiss));
            }
            catch(ParseException ex) {
                membre.setDatenaiss(new Date());
            }
            //set datedelivrancecni
            try {
                membre.setDatedelivrancecni(dateFormat.parse(this.dateDelivranceCni));
            }
            catch(ParseException ex) {
                membre.setDatedelivrancecni(new Date());
            }
            //set dateadhesion
            try {
                membre.setDateadhesion(dateFormat.parse(this.dateAdhesion));
            }
            catch(ParseException ex) {
                membre.setDatedelivrancecni(new Date());
            }
            //set Matricule et Mot de pass
            mat = generateMatricule();
            System.out.println("Matricule généré" + mat);
            pass = generatePass();
            System.out.println("Password généré" + pass);
            membre.setMatricule(mat);
            membre.setPwd(pass);
            
            UserTransaction transaction = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
            transaction.begin();
            membre = em.merge(membre);
            transaction.commit();

            this.submitted = true;
        }
        return "";
    }
    
    public String newInscription() {
        this.membre = new Membres();
        this.submitted = false;
        return "inscription.xhtml?faces-redirect=true";
    }
    
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Membres getMembre() {
        return membre;
    }

    public void setMembre(Membres membre) {
        this.membre = membre;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getDateAdhesion() {
        return dateAdhesion;
    }

    public void setDateAdhesion(String dateAdhesion) {
        this.dateAdhesion = dateAdhesion;
    }

    public String getDateDelivranceCni() {
        return dateDelivranceCni;
    }

    public void setDateDelivranceCni(String dateDelivranceCni) {
        this.dateDelivranceCni = dateDelivranceCni;
    }

    public String getMat() {
        return mat;
    }

    public void setMat(String mat) {
        this.mat = mat;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    private String generateMatricule() {
        String mois, matricule = "";
        int annee;
        mois = Calendar.getInstance().getDisplayName(Calendar.MONTH, Calendar.SHORT_STANDALONE, Locale.ENGLISH).toUpperCase();
        annee = Calendar.getInstance().get(Calendar.YEAR);
        Random rand = new Random();
        boolean matriculeExistant = false;
        List<Membres> membreList  = getEm().createNamedQuery("Membres.findByMatricule").setParameter("matricule", matricule).getResultList();
        do {
            //generation du matricule
            matricule = String.valueOf(annee).substring(2, 4) + mois + String.valueOf(rand.nextInt(10)) + String.valueOf(rand.nextInt(10)) + String.valueOf(rand.nextInt(10));
            //test sur l'existance potentiel de ce matricule en BD
            for(Membres m : membreList) {
                if(m.getMatricule().equals(matricule)) {
                    matriculeExistant = true;
                    break;
                    //on genere un autre
                }
            }
        }
        while(matriculeExistant);
        return matricule;
    }

    private String generatePass() {
        Random r = new Random();
        String[] val = {"a", "b", "c", "d", "e", "f", "g", "h", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "v", "w", "x", "y", "z"};
        return val[r.nextInt(val.length)] + String.valueOf(r.nextInt(10)) + String.valueOf(r.nextInt(10)) + String.valueOf(r.nextInt(10));
    }
    
}
