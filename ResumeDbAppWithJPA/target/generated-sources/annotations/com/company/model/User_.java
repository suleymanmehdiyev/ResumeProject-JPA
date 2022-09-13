package com.company.model;

import com.company.model.ContactDetail;
import com.company.model.Education;
import com.company.model.EmploymentHistory;
import com.company.model.UserSkill;
import java.sql.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-09-13T14:44:27", comments="EclipseLink-2.7.9.v20210604-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Date> birthdate;
    public static volatile ListAttribute<User, Education> education;
    public static volatile SingularAttribute<User, String> uname;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile SingularAttribute<User, String> citizenship;
    public static volatile SingularAttribute<User, String> about;
    public static volatile ListAttribute<User, UserSkill> skills;
    public static volatile ListAttribute<User, EmploymentHistory> employmentHistory;
    public static volatile SingularAttribute<User, String> patronymic;
    public static volatile SingularAttribute<User, String> password;
    public static volatile ListAttribute<User, ContactDetail> contactDetail;
    public static volatile SingularAttribute<User, String> surname;
    public static volatile SingularAttribute<User, String> military;
    public static volatile SingularAttribute<User, Integer> id;
    public static volatile SingularAttribute<User, String> maritalStatus;
    public static volatile SingularAttribute<User, String> email;

}