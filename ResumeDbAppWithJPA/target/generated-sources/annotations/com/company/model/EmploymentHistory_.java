package com.company.model;

import com.company.model.User;
import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(EmploymentHistory.class)
public class EmploymentHistory_ { 

    public static volatile SingularAttribute<EmploymentHistory, Date> beginDate;
    public static volatile SingularAttribute<EmploymentHistory, Date> endDate;
    public static volatile SingularAttribute<EmploymentHistory, String> companyName;
    public static volatile SingularAttribute<EmploymentHistory, Integer> id;
    public static volatile SingularAttribute<EmploymentHistory, String> position;
    public static volatile SingularAttribute<EmploymentHistory, String> jobDesc;
    public static volatile SingularAttribute<EmploymentHistory, User> userId;

}