package com.company.model;

import com.company.model.City;
import com.company.model.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(ContactDetail.class)
public class ContactDetail_ { 

    public static volatile SingularAttribute<ContactDetail, String> actualAddress;
    public static volatile SingularAttribute<ContactDetail, String> phoneNumber;
    public static volatile SingularAttribute<ContactDetail, Integer> id;
    public static volatile SingularAttribute<ContactDetail, City> regAddress;
    public static volatile SingularAttribute<ContactDetail, User> userId;

}