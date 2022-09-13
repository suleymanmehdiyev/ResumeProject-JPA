/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * @author User
 */
@Entity
@Table(name = "user",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Cacheable(value = false)
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
    Integer id;
    @Basic(optional = false)
    @Column(name = "uname")
    String uname;
    @Basic(optional = false)
    @Column(name = "surname")
    String surname;
    @Column(name = "patronymic")
    String patronymic;
    @Column(name = "birthdate")
    Date birthdate;
    @Column(name = "gender")
    String gender;
    @Column(name = "marital_status")
    String maritalStatus;
    @Column(name = "citizenship")
    String citizenship;
    @Column(name = "military")
    String military;
    @Column(name = "about")
    String about;
    @Basic(optional = false)
    @Column(name = "email")
    String email;
    @Basic(optional = false)
    @Column(name = "password")
    String password;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "userId")
    List<Education> education;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<UserSkill> skills;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    List<EmploymentHistory> employmentHistory;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    List<ContactDetail> contactDetail;

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String uname, String surname, String email, String password) {
        this.id = id;
        this.uname = uname;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String uname, String surname, String patronymic, java.sql.Date birthdate, String gender, String maritalStatus, String citizenship, String military, String about) {
        this.id = id;
        this.uname = uname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
        this.military = military;
        this.about = about;
    }

    public User(Integer id, String uname, String surname, String patronymic, java.sql.Date birthdate, String gender, String maritalStatus, String citizenship, String military, String about, String email, String password) {
//        this(id,uname,surname,patronymic,birthdate,gender,maritalStatus,citizenship,military,about);
        this.id = id;
        this.uname = uname;
        this.surname = surname;
        this.patronymic = patronymic;
        this.birthdate = birthdate;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.citizenship = citizenship;
        this.military = military;
        this.about = about;
        this.email = email;
        this.password = password;

    }
//    public User(Integer id, String uname, String surname, String patronymic, java.sql.Date birthdate, String gender, String maritalStatus, String citizenship, String military, String about, String email, String password, List<ContactDetail> cd, List<UserSkill> skills, List<EmploymentHistory> employmentHistory, List<Education> education) {
////        this(id, uname, surname, patronymic, birthdate, gender, maritalStatus, citizenship, military, about,email,password);
//        this.skills = skills;
//        this.contactDetail = cd;
//        this.employmentHistory = employmentHistory;
//        this.education = education;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthdate=" + birthdate +
                ", gender='" + gender + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", military='" + military + '\'' +
                ", about='" + about + '\'' +
                ", email='" + email + '\'' +
                ", contactDetail=" + contactDetail +
                ", skills=" + skills +
                ", employmentHistory=" + employmentHistory +
                ", education=" + education +
                '}';
    }
}
