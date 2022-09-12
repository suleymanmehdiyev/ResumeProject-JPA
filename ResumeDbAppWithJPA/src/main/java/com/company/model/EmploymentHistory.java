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
@Table(name = "employment_history",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmploymentHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_sequence")
    @SequenceGenerator(name = "emp_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
    Integer id;
    @Column(name = "begin_date")
    @Temporal(TemporalType.DATE)
    Date beginDate;
    @Column(name = "company_name")
    String companyName;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    Date endDate;
    @Column(name = "job_description")
    String jobDesc;
    @Column(name = "job_position")
    String position;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    User userId;

    @Override
    public String toString() {
        return "EmploymentHistory{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", beginDate=" + beginDate +
                ", endDate=" + endDate +
                ", jobDesc='" + jobDesc + '\'' +
                ", userId=" + userId +
                '}';
    }

}
