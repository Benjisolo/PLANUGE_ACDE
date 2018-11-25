package com.acde.planuge.managedBeans;

import com.acde.planuge.entity.Membres;
import com.acde.planuge.entity.TypeVersement;
import com.acde.planuge.entity.Versement;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
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

@ManagedBean(name="adminBean")
@ApplicationScoped
public class AdminBean implements Serializable {
    /*@ManagedProperty(value="#{membreToViewBean}")
    private MembreToViewBean membreToViewBean;*/
    @PersistenceContext(unitName="planugeAcdePU")
    private EntityManager em;
    private UserTransaction trans;
    private List<Membres> membreList, membreToDeleteList;
    private List<Versement> versementList;
    private List<TypeVersement> typeVersementList;
    private String search, membreAvatar, montant, type, labelType, idType;
    private Membres membreSelected, membreToDelete;
    private TypeVersement typeVersementSelected;
    private Date date;
    private DateFormat df;

    public AdminBean() throws NamingException {
        this.membreList = new ArrayList<>();
        this.membreToDeleteList = new ArrayList<>();
        this.membreSelected = new Membres();
        this.membreToDelete = new Membres();
        this.typeVersementSelected = new TypeVersement();
        this.versementList = new ArrayList<>();
        this.typeVersementList = new ArrayList();
        trans = (UserTransaction) new InitialContext().lookup("java:comp/UserTransaction");
    }
    
    @PostConstruct
    public void initList() {
        this.membreList = getEm().createNamedQuery("Membres.findAll").getResultList();
        this.membreList.add(new Membres("18JUN648"));
        this.versementList = getEm().createNamedQuery("Versement.findAll").getResultList();
        Collections.reverse(versementList);
        this.typeVersementList = getEm().createNamedQuery("TypeVersement.findAll").getResultList();
    }
    
    public void changeMembre(Membres m) {
        this.membreSelected = m;
    }
    
    public void toDelete(Membres membre, String checked) {
        membreToDelete = membre;
        System.out.println("delete : "+checked);
        //if(checked.equals("true")) {
            System.out.println("Selected: "+membreToDelete.getMatricule()+" - "+membreToDelete.getNom());
            this.membreToDeleteList.add(membreToDelete);
        //}
        //else {
            //this.membreToDeleteList.remove(membre);
        //}
        System.out.println("nbr: "+membreToDeleteList.size());
    }
    
    public void nouveauVersement() throws SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException, NotSupportedException {
        for(TypeVersement tv : typeVersementList) {
            if(tv.getId().equals(type)) {
                typeVersementSelected = tv;
                break;
            }
        }
        trans.begin();
        em.merge(new Versement(typeVersementSelected, Calendar.getInstance().getTime(), membreSelected, BigInteger.valueOf(Integer.parseInt(montant))));
        trans.commit();
        reloadVersements();
    }
    
    public void reloadVersements() {
        this.versementList = getEm().createNamedQuery("Versement.findAll").getResultList();
        Collections.reverse(versementList);
    }
    
    public void reloadMembres() {
        this.membreList = getEm().createNamedQuery("Membres.findAll").getResultList();
        this.membreList.add(new Membres("18JUN648"));
    }
    
    public void deleteMembre(Membres membreToDelete) throws NotSupportedException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException {
        System.out.println("Removing...");
        for(Membres m : this.membreList) {
            System.out.println(membreToDelete.getMatricule());
            if(m.getMatricule().equals(membreToDelete.getMatricule())) {
                trans.begin();
                getEm().remove(getEm().merge(m));
                trans.commit();
                break;
            }
        }
        System.out.println("Removed!");
    }
    
    public void newTypeVersement() throws NotSupportedException, SystemException, RollbackException, HeuristicMixedException, HeuristicRollbackException {
        trans.begin();
        em.merge(new TypeVersement(idType, labelType));
        trans.commit();
        reloadTypeVersements();
    }
    
    public void reloadTypeVersements() {
        this.typeVersementList = getEm().createNamedQuery("TypeVersement.findAll").getResultList();
    }
    
    public void getFicheMembreToView(String annee) {
        // todo task
    }
    
    public List<Membres> getMembreList() {
        return membreList;
    }

    public void setMembreList(List<Membres> membreList) {
        this.membreList = membreList;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Membres> getMembreToDeleteList() {
        return membreToDeleteList;
    }

    public void setMembreToDeleteList(List<Membres> membreToDeleteList) {
        this.membreToDeleteList = membreToDeleteList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Membres getMembreToDelete() {
        return membreToDelete;
    }

    public void setMembreToDelete(Membres membreToDelete) {
        this.membreToDelete = membreToDelete;
    }

    public UserTransaction getTrans() {
        return trans;
    }

    public void setTrans(UserTransaction trans) {
        this.trans = trans;
    }

    public String getMembreAvatar() {
        return membreAvatar;
    }

    public void setMembreAvatar(String membreAvatar) {
        this.membreAvatar = membreAvatar;
    }

    public List<Versement> getVersementList() {
        return versementList;
    }

    public void setVersementList(List<Versement> versementList) {
        this.versementList = versementList;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDf() {
        return df;
    }

    public void setDf(DateFormat df) {
        this.df = df;
    }
    
    public int getYear(int annee) {
        return annee+1900;
    }
    
    public String getMonth(int mois) {
        String[] months = {"Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"};
        return months[mois];
    }
/*
    public void setMembreToViewBean(MembreToViewBean membreToViewBean) {
        this.membreToViewBean = membreToViewBean;
    }*/

    public Membres getMembreSelected() {
        return membreSelected;
    }

    public void setMembreSelected(Membres membreSelected) {
        this.membreSelected = membreSelected;
    }

    public TypeVersement getTypeVersementSelected() {
        return typeVersementSelected;
    }

    public void setTypeVersementSelected(TypeVersement typeVersementSelected) {
        this.typeVersementSelected = typeVersementSelected;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<TypeVersement> getTypeVersementList() {
        return typeVersementList;
    }

    public void setTypeVersementList(List<TypeVersement> typeVersementList) {
        this.typeVersementList = typeVersementList;
    }

    public String getLabelType() {
        return labelType;
    }

    public void setLabelType(String labelType) {
        this.labelType = labelType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

}
