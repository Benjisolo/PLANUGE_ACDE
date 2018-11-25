package com.acde.planuge.managedBeans;

import com.acde.planuge.entity.Membres;
import com.acde.planuge.entity.TypeVersement;
import com.acde.planuge.entity.Versement;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ►BenjiS☼l☼
 */

@ManagedBean(name="membreToViewBean")
@ApplicationScoped
public class MembreToViewBean implements Serializable {
    @PersistenceContext(unitName="planugeAcdePU")
    private EntityManager em;
    private Membres membre;
    private String c10, c100, insc;
    private String[][] versementsParMois;
    private List<Versement> versementList;
    private List<TypeVersement> typeVersementList;

    public MembreToViewBean() {
        this.versementList = new ArrayList<>();
        this.typeVersementList = new ArrayList();
        this.membre = new Membres();
    }
    
    public String viewMembre(Membres m, String annee) {
        this.membre = m;
        System.out.println("membre: "+this.membre.getMatricule());
        this.versementList = getEm().createNamedQuery("Versement.findAllOfMembre").setParameter("membre", this.membre).getResultList();
        this.typeVersementList = getEm().createNamedQuery("TypeVersement.findAll").getResultList();
        
        for(int i=0; i<12; i++) {
            for(Versement v: versementList) {
                LocalDate localDate = v.getDateversement().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                if(localDate.getYear() == 2018 && localDate.getMonthValue() == i+1) {
                    String typeVers = v.getType().getId();
                    //System.out.println(i+":"+v.getDateversement()+":"+v.getType());
//                    switch(typeVers) {
//                        case "fs" : {versementsParMois[i][0] = String.valueOf(v.getMontant());}break;
//                        case "fa" : {versementsParMois[i][1] = String.valueOf(v.getMontant());}break;
//                        case "col" : {versementsParMois[i][2] = String.valueOf(v.getMontant());}break;
//                        case "c1" : {versementsParMois[i][3] = String.valueOf(v.getMontant());}break;
//                        case "c2" : {versementsParMois[i][4] = String.valueOf(v.getMontant());}break;
//                        case "es" : {versementsParMois[i][5] = String.valueOf(v.getMontant());}break;
//                        case "ea" : {versementsParMois[i][6] = String.valueOf(v.getMontant());}break;
//                        case "rem" : {versementsParMois[i][7] = String.valueOf(v.getMontant());}break;
//                        case "ip" : {versementsParMois[i][8] = String.valueOf(v.getMontant());}break;
//                        case "ret" : {versementsParMois[i][9] = String.valueOf(v.getMontant());}break;
//                        case "abs" : {versementsParMois[i][10] = String.valueOf(v.getMontant());}break;
//                        case "ton" : {versementsParMois[i][11] = String.valueOf(v.getMontant());}break;
//                        default : {System.out.println("Erreur 'typeVersement': aucune donnee ne correspond a "+typeVers);}
//                    }
                }
            }
        }
//        for(String[] v : versementsParMois) {
//            for(String mnt : v) {
//                System.out.println(mnt);
//            }
//        }
        System.out.println("Versemts Memb: "+versementList.size());
//        for(int i=1; i<=12; i++) {
//            for(int j=0; j< typeVersementList.size(); j++) {
//                //versementsParMois[i][j] = String.valueOf(getVersement(i, typeVersementList.get(j)));
//                System.out.println(getVersement(i, typeVersementList.get(j)));
//            }
//            System.out.println();
//        }
        return "profil_membre.xhtml?faces-redirect=true";
    }

    public Membres getMembre() {
        return membre;
    }

    public void setMembre(Membres membre) {
        this.membre = membre;
    }

    public List<Versement> getVersementList() {
        return versementList;
    }

    public void setVersementList(List<Versement> versementList) {
        this.versementList = versementList;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public String getC10() {
        return c10;
    }

    public void setC10(String c10) {
        this.c10 = c10;
    }

    public String getC100() {
        return c100;
    }

    public void setC100(String c100) {
        this.c100 = c100;
    }

    public String getInsc() {
        return insc;
    }

    public void setInsc(String insc) {
        this.insc = insc;
    }

    public List<TypeVersement> getTypeVersementList() {
        return typeVersementList;
    }

    public void setTypeVersementList(List<TypeVersement> typeVersementList) {
        this.typeVersementList = typeVersementList;
    }

    private BigInteger getVersement(int month, TypeVersement typeVersement) {
        LocalDate localDate;
        BigInteger montant = null;
        System.out.println("BEFORE");
        for(Versement v : versementList) {
            //if(v.getType().equals("c10"))
                System.out.println(v);
//        System.out.println("DATE");
//            localDate = v.getDateversement().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        System.out.println("MOIS");
//            int m = localDate.getMonthValue();
//        System.out.println("TYPE");
//            String t = v.getType().getId();
//        System.out.println("TEST");
//            if(m == month && t.equals(typeVersement.getId())) {
//                System.out.println("m: "+m+", month: "+month+", t: "+t+", typeV: "+typeVersement.getId()+", montant: "+v.getMontant());
//                montant = v.getMontant();
//                System.out.println("GOOD");
//            }
        }
        System.out.println("AFTER");
        return montant;
    }

    public String[][] getVersementsParMois() {
        return versementsParMois;
    }

    public void setVersementsParMois(String[][] versementsParMois) {
        this.versementsParMois = versementsParMois;
    }
    
}
