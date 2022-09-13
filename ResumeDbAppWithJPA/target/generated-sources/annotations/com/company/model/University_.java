package com.company.model;

import com.company.model.Education;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(University.class)
public class University_ { 

    public static volatile SingularAttribute<University, String> uniName;
    public static volatile ListAttribute<University, Education> education;
    public static volatile SingularAttribute<University, Integer> id;

}