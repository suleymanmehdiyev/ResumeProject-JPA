package com.company.model;

import com.company.model.ContactDetail;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile ListAttribute<City, ContactDetail> contactDetail;
    public static volatile SingularAttribute<City, String> cityName;
    public static volatile SingularAttribute<City, Integer> id;

}