package com.company.dao.inter;

import com.company.model.Education;
import com.company.model.User;

import java.util.List;

public interface EducationDAOInter {
    List<Education> getAllEducation(User userId);
    Education getEducationById(Integer id);
    Education addEducation(Education education);
    Education updateEducation(Education education);
    void deleteEducation(User userId);
}
