package com.company.model;

import com.company.model.University;
import com.company.model.User;
import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(Education.class)
public class Education_ { 

    public static volatile SingularAttribute<Education, String> speciality;
    public static volatile SingularAttribute<Education, Date> beginDate;
    public static volatile SingularAttribute<Education, University> universityId;
    public static volatile SingularAttribute<Education, Date> endDate;
    public static volatile SingularAttribute<Education, String> degree;
    public static volatile SingularAttribute<Education, Integer> id;
    public static volatile SingularAttribute<Education, User> userId;

}