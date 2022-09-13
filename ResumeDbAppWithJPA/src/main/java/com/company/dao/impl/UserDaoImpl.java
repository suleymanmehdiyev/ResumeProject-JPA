package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.dao.inter.UserDAOInter;
import com.company.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDAOInter {


    @Override
    public List<User> getAll() {
        EntityManager em = em();
        em.getTransaction().begin();
        Query query = em.createQuery("select u from User u");
        List<User> users = query.getResultList();
        em.getTransaction().commit();
        em.close();
         return users;
    }

    @Override
    public List<User> getAllNameAndSurname(String uname, String surname, String patronymic) {
            EntityManager em = em();

            String jpql = "select u from User u where 1 = 1 ";

            if (uname != null && !(uname.trim().isEmpty())) {
                jpql += " and u.uname =:uname ";
            }
            if (surname != null && !(surname.trim().isEmpty())) {
                jpql += " and u.surname =:surname ";
            }
            if (patronymic != null && !(patronymic.trim().isEmpty())) {
                jpql += " and u.patronymic =:patronymic ";
            }

            Query query = em.createQuery(jpql,User.class);

            if (uname != null && !(uname.trim().isEmpty())) {
                query.setParameter("uname",uname);
            }
            if (surname != null && !(surname.trim().isEmpty())) {
                query.setParameter("surname",surname);
            }
            if (patronymic != null && !(patronymic.trim().isEmpty())) {
                query.setParameter("patronymic",patronymic);
            }

        return query.getResultList();
    }

    @Override
    public User getById(int id) {
        EntityManager em = em();

        User u = em.find(User.class,id);
        em.close();
        return u;
    }
private BCrypt.Hasher bCrypt = BCrypt.withDefaults();


    @Override
    public User addUser(User u) {
        EntityManager em = em();

        em.getTransaction().begin();
        u.setPassword(bCrypt.hashToString(4,u.getPassword().toCharArray()));
        em.persist(u);
        em.getTransaction().commit();
        em.close();
        return u;
    }

    @Override
    public User updateUser(User u) {
        EntityManager em = em();
        em.getTransaction().begin();
        String sql = "update User u set u.uname=:uname,u.surname=:surname,u.patronymic=:patronymic," +
                "u.birthdate=:birthdate,u.gender=:gender,u.maritalStatus=:maritalStatus," +
                "u.citizenship=:citizenship,u.military=:military,u.about=:about where u.id=:id";
        Query query = em.createQuery(sql);
        query.setParameter("uname",u.getUname());
        query.setParameter("surname",u.getSurname());
        query.setParameter("patronymic",u.getPatronymic());
        query.setParameter("birthdate",u.getBirthdate());
        query.setParameter("gender",u.getGender());
        query.setParameter("maritalStatus",u.getMaritalStatus());
        query.setParameter("citizenship",u.getCitizenship());
        query.setParameter("military",u.getMilitary());
        query.setParameter("about",u.getAbout());
        query.setParameter("id",u.getId());
        query.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return u;
    }

    @Override
    public void deleteUser(int id) {
        EntityManager em = em();

        em.getTransaction().begin();
        User u = em.find(User.class,id);
        em.remove(u);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public User findByUserEmail(String email) {
        EntityManager em = em();
        String sql = "select u from User u where u.email=:email";
        Query query = em.createQuery(sql);
        query.setParameter("email",email);
        List<User> emailUser = query.getResultList();
        if(emailUser.size()==1){
            return emailUser.get(0);
        }
        return null;
    }
}
