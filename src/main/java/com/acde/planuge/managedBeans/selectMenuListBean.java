/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.acde.planuge.managedBeans;

import com.acde.planuge.entity.TypeVersement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author ►BenjiS☼l☼
 */

@ManagedBean(name="selectMenuListBean")
@SessionScoped
public class selectMenuListBean implements Serializable {
    @PersistenceContext(unitName="planugeAcdePU")
    EntityManager em;
    private List<TypeVersement> typeVersementList;
    
    public selectMenuListBean() {
        this.typeVersementList = new ArrayList();
    }
    
    @PostConstruct
    public void initList() {
        this.typeVersementList = getEm().createNamedQuery("TypeVersement.findAll").getResultList();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<TypeVersement> getTypeVersementList() {
        return typeVersementList;
    }

    public void setTypeVersementList(List<TypeVersement> typeVersementList) {
        this.typeVersementList = typeVersementList;
    }
    
}
