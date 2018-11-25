package com.acde.planuge.entity;

import com.acde.planuge.entity.Membres;
import com.acde.planuge.entity.TypeVersement;
import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-07-20T02:45:12")
@StaticMetamodel(Versement.class)
public class Versement_ { 

    public static volatile SingularAttribute<Versement, Date> dateversement;
    public static volatile SingularAttribute<Versement, Membres> idmembre;
    public static volatile SingularAttribute<Versement, BigInteger> montant;
    public static volatile SingularAttribute<Versement, Long> id;
    public static volatile SingularAttribute<Versement, TypeVersement> type;

}