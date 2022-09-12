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
import java.util.List;

/**
 *
 * @author User
 */
@Entity
@Table(name = "university",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class University implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uni_sequence")
    @SequenceGenerator(name = "uni_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
     Integer id;
    @Column(name = "uni_name")
    String uniName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "universityId")
    List<Education> education;

    public University(Integer id) {
        this.id = id;
    }

    public University(Integer id, String uniName) {
        this.id = id;
        this.uniName = uniName;
    }
}
