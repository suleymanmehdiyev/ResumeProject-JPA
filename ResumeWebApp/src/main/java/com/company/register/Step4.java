package com.company.register;

import com.company.config.Config;
import com.company.dao.inter.EducationDAOInter;
import com.company.dao.inter.EmploymentHistoryDAOInter;
import com.company.main.Context;
import com.company.model.Education;
import com.company.model.EmploymentHistory;
import com.company.model.University;
import com.company.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Step4", value = "/step4")
public class Step4 extends HttpServlet {
    EmploymentHistoryDAOInter empHistoryDAO = Context.instanceEmploymentHistoryDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("register/step4.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int userId = Integer.parseInt(request.getParameter("userId"));
            String companyName = request.getParameter("company");
            String position = request.getParameter("position");
            String jobDesc = request.getParameter("responsibilities");
            String beginDate = request.getParameter("beginDate");
            String endDate = request.getParameter("endDate");


           //find employmentHistories to userid
            List<EmploymentHistory> emp = empHistoryDAO.getAllEmploymentHistory(new User(userId));

            System.out.println(emp);
            EmploymentHistory newEmp = null;


            if(emp.isEmpty()){
                newEmp =new EmploymentHistory(null,Config.parseDate(beginDate), companyName, Config.parseDate(endDate),jobDesc,position, new User(userId));
                empHistoryDAO.addEmploymentHistory(newEmp);
            }else{
                newEmp = new EmploymentHistory(emp.get(0).getId(), Config.parseDate(beginDate), companyName, Config.parseDate(endDate),jobDesc,position, new User(userId));
                empHistoryDAO.updateEmploymentHistory(newEmp);
            }
            response.sendRedirect("step5");

        }catch (Exception ex){
            ex.printStackTrace();
            response.sendRedirect("error?msg= " + ex.getMessage());
        }
    }
}
