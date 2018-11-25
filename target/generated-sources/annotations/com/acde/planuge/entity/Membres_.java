package com.acde.planuge.entity;

import com.acde.planuge.entity.Versement;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-20T02:45:12")
@StaticMetamodel(Membres.class)
public class Membres_ { 

    public static volatile SingularAttribute<Membres, BigInteger> numcni;
    public static volatile SingularAttribute<Membres, String> matricule;
    public static volatile SingularAttribute<Membres, String> adresseemployeur;
    public static volatile SingularAttribute<Membres, BigInteger> nombrepersonneacharge;
    public static volatile SingularAttribute<Membres, String> sexe;
    public static volatile SingularAttribute<Membres, String> nom;
    public static volatile SingularAttribute<Membres, String> villeresidence;
    public static volatile SingularAttribute<Membres, String> activiteprofessionelle;
    public static volatile SingularAttribute<Membres, String> lieuexercicefonction;
    public static volatile ListAttribute<Membres, Versement> versementList;
    public static volatile SingularAttribute<Membres, Date> dateadhesion;
    public static volatile SingularAttribute<Membres, String> residencepere;
    public static volatile SingularAttribute<Membres, String> nomemployeur;
    public static volatile SingularAttribute<Membres, Date> datedelivrancecni;
    public static volatile SingularAttribute<Membres, String> langue1;
    public static volatile SingularAttribute<Membres, String> lieudelivrancecni;
    public static volatile SingularAttribute<Membres, String> regimematrimonial;
    public static volatile SingularAttribute<Membres, String> lieunaiss;
    public static volatile SingularAttribute<Membres, String> nommere;
    public static volatile SingularAttribute<Membres, String> prenom;
    public static volatile SingularAttribute<Membres, String> email;
    public static volatile SingularAttribute<Membres, String> situationmatrimoniale;
    public static volatile SingularAttribute<Membres, BigInteger> nombreenfantlegitime;
    public static volatile SingularAttribute<Membres, String> residencemere;
    public static volatile SingularAttribute<Membres, String> lieuactiviteprof;
    public static volatile SingularAttribute<Membres, String> nomconjoint;
    public static volatile SingularAttribute<Membres, BigInteger> numtel1;
    public static volatile SingularAttribute<Membres, BigInteger> numtel2;
    public static volatile SingularAttribute<Membres, String> adresse;
    public static volatile SingularAttribute<Membres, String> fonction;
    public static volatile SingularAttribute<Membres, String> raisondadhesion;
    public static volatile SingularAttribute<Membres, String> pwd;
    public static volatile SingularAttribute<Membres, Date> datenaiss;
    public static volatile SingularAttribute<Membres, String> lieuadhesion;
    public static volatile SingularAttribute<Membres, String> nompere;

}