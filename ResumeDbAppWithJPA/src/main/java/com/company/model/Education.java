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
import java.util.Date;

/**
 * @author User
 */
@Entity
@Table(name = "education",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Education implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "edu_sequence")
    @SequenceGenerator(name = "edu_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
    Integer id;
    @Column(name = "degree")
    String degree;
    @Column(name = "speciality")
    String speciality;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    Date beginDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;
    @JoinColumn(name = "university_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    University universityId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    User userId;

    public Education(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Education{" +
                "id=" + id +
                ", degree='" + degree + '\'' +
                ", speciality='" + speciality + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", universityId=" + universityId +
                '}';
    }

}
