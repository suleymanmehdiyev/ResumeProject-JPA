package com.company.dao.inter;

import com.company.model.User;
import com.company.model.UserSkill;

import java.util.List;

public interface UserSkillDAOInter {
    List<UserSkill> getAllUserSkill(User userId);
    UserSkill getById(Integer id);
    UserSkill addUserSkill(UserSkill userSkill);
    UserSkill updateUserSkill(UserSkill userSkill);
    void deleteUserSkill(Integer id);
}
