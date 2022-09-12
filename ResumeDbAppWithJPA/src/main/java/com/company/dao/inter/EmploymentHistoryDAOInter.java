package com.company.dao.inter;

import com.company.model.EmploymentHistory;
import com.company.model.User;

import java.util.List;

public interface EmploymentHistoryDAOInter {
    List<EmploymentHistory> getAllEmploymentHistory(User userId);
    EmploymentHistory getEmploymentHistoryById(Integer id);
    EmploymentHistory addEmploymentHistory(EmploymentHistory employmentHistory);
    EmploymentHistory updateEmploymentHistory(EmploymentHistory employmentHistory);
    void deleteEmploymentHistory(Integer id);
}
