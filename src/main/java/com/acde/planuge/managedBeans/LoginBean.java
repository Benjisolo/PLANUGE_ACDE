package com.acde.planuge.managedBeans;

import com.acde.planuge.entity.Membres;
import com.acde.planuge.models.Menu;
import com.acde.planuge.models.User;
import com.acde.planuge.utils.SessionUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;

/**
 * @author ►BenjiS☼l☼
 */
@ManagedBean(name="loginBean")
@ApplicationScoped
public class LoginBean implements Serializable {
    @PersistenceContext(unitName="planugeAcdePU")
    private EntityManager em;
    @ManagedProperty("#{adminBean}")
    private AdminBean insB;
    private User user;
    private ArrayList<Menu> menuList;
    private boolean logged = false;

    public LoginBean() {
        user = new User();
        menuList = new ArrayList<>();
        //login();
    }
    
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }
    
    // --- Conditions Pour le rendu visuel ---
    public boolean isMenuRendered(String idMenu) {
        boolean flag = false;
        for(Menu m : menuList) {
            if(m.getIdMenu().equals(idMenu)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
    
    public String login() {
        String s = "index.xhtml?faces-redirect=true";
        if(membreExiste()) {
            if(this.user.getCurrentMembre().getFonction() == null) {
                setMenus("");
            }
            else if(this.user.getCurrentMembre().getFonction().equals("admin")) {
                setMenus("admin");
            }
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", this.user.getCurrentMembre().getPrenom()+" "+this.user.getCurrentMembre().getNom());
            if(this.user.getCurrentMembre().getFonction() == null) 
                session.setAttribute("usergroup", "");
            else 
                session.setAttribute("usergroup", this.user.getCurrentMembre().getFonction());
            this.logged = true;
        }
        else {
            s = "";
            FacesMessage msg = new FacesMessage("Matricule ou mot de passe incorrect! Veuillez réessayer svp.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
            System.out.println("Current User[name="+this.user.getLogin()+", groupe="+SessionUtils.getUserGroup());
        return s;
    }
    
    public boolean membreExiste() {
        boolean flag = false;
        List<Membres> listMembre = getEm().createNamedQuery("Membres.findByMatricule").setParameter("matricule", this.user.getLogin()).getResultList();
        for(Membres m : listMembre) {
            if(m.getMatricule().equals(this.user.getLogin()) && m.getPwd().equals(this.user.getPassword())) {
                flag = true;
                this.user.setCurrentMembre(m);
                this.insB.setMembreSelected(m);
                return flag;
            }
        }
        return flag;
    }
    
    public void setMenus(String group) {
        menuList.clear();
        switch(group) {
            case "admin" : {
                menuList.add(new Menu("profileMembre", "/pages/profil_membre.xhtml"));
                menuList.add(new Menu("dashboard", "/pages/dashboard.xhtml"));
                menuList.add(new Menu("inscription", "/pages/inscription.xhtml"));
                menuList.add(new Menu("listeMembres", "/pages/liste_membres.xhtml"));
                menuList.add(new Menu("historiqueVersements", "/pages/historiqueversements.xhtml"));
                menuList.add(new Menu("typesVersement", "/pages/types_versement.xhtml"));
                menuList.add(new Menu("c10", "/pages/c10.xhtml"));
                menuList.add(new Menu("c100", "/pages/c100.xhtml"));
                menuList.add(new Menu("epargneScolaire", "/pages/epargne_scolaire.xhtml"));
                menuList.add(new Menu("epargneAnnuelle", "/pages/epargne_annuelle.xhtml"));
                menuList.add(new Menu("amandes", "/pages/amandes.xhtml"));
            }break;
            case "" : {
                menuList.add(new Menu("inscription", "/pages/inscription.xhtml"));
                menuList.add(new Menu("versements", "/pages/versement.xhtml"));
                menuList.add(new Menu("profilUser", "/pages/profil_user.xhtml"));
            }break;
            default : {System.err.println("Erreur de groupe de l'utilisateur");}
        }
    }
    
    public String logout() {
        String s = "login.xhtml?faces-redireect=true";
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        this.logged = false;
        return s;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void setInsB(AdminBean insB) {
        this.insB = insB;
    }
    
}
