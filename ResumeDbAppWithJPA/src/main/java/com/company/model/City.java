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
@Table(name = "city",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    @SequenceGenerator(name = "city_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
    Integer id;
    @Column(name = "city_name")
   String cityName;
    @OneToMany(mappedBy = "regAddress")
    List<ContactDetail> contactDetail;

    public City(Integer id) {
        this.id = id;
    }
    public City(String cityName) {
        this.cityName = cityName;
    }
    public City(Integer id,String cityName){
        this.id = id;
        this.cityName = cityName;
    }

    @Override
    public String toString() {
        return cityName;
    }
    
}
