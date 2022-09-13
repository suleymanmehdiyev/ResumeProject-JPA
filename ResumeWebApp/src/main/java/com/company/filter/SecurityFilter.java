package com.company.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "JSPFileFilter")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) {
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            HttpSession session = req.getSession();

            if(session==null && req.getSession().getAttribute("loggedInUser") == null){
                req.getRequestDispatcher("home").forward(req,res);
            }else{
                chain.doFilter(request,response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
