package com.company.main;

import com.company.dao.inter.ContactDetailDAOInter;
import com.company.dao.inter.EmploymentHistoryDAOInter;
import com.company.dao.inter.UserDAOInter;
import com.company.dao.inter.UserSkillDAOInter;
import com.company.model.*;

public class Main {

    public static void main(String[] args) throws Exception {

//        UserDAOInter userDAOInter = Context.instanceUserDAO();
//        User u = new User(3,"Nerminn","Gulieva","nermin@gmail.com","12345678");
//        System.out.println(userDAOInter.getAllNameAndSurname(null,"Gulieva",null));

//        UserSkillDAOInter userSkill = Context.instanceUserSkillDAO();
//        UserSkill us = new UserSkill(null,new Skill(1),new User(1));
//        System.out.println(userSkill.addUserSkill(us));
//        userSkill.deleteUserSkill(new User(1));

//        UniversityDAOInter universityDAOInter = Context.instanceUniversityDAO();
//        University uni = new University(3,"Xezer Universiteti");
//        System.out.println(universityDAOInter.updateUniversity(uni));

//        SkillDAOInter daoInter = Context.instanceSkillDAO();
//        Skill skill = daoInter.updateSkill(new Skill(1,"Java"));
//        System.out.println(daoInter.getAll());

//        EmploymentHistoryDAOInter employmentHistoryDAOInter = Context.instanceEmploymentHistoryDAO();
//        EmploymentHistory employmentHistory = new EmploymentHistory(2,new Date(2000-11-07),"Galactech",new Date(2000-11-07),"back end developer","Back end",new User(1));
//        User user = userDAOInter.getById(1);
//        System.out.println(employmentHistoryDAOInter.getAllEmploymentHistory(new User(1)));

//          EducationDAOInter educationDAOInter = Context.instanceEducationDAO();
//          Education edu = new Education(1,"Master","Optotexnika",new Date(2000-11-07),new Date(2000-11-07),new University(1),new User(1));
//          educationDAOInter.deleteEducation(new User(2));

        ContactDetailDAOInter contactDetailDAOInter = Context.instanceContactDetailDAO();
//        ContactDetail cd = new ContactDetail(null,null,null,new City(1),new User(1));
//        contactDetailDAOInter.addContactDetail(cd);
        contactDetailDAOInter.deleteContactDetailByUserId(new User(1));

//        CityDAOInter daoInter = Context.instanceCityDAO();
//        System.out.println(daoInter.getById(1));

    }


}

