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

/**
 *
 * @author User
 */
@Entity
@Table(name = "contactdetail",schema = "public")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ContactDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cd_sequence")
    @SequenceGenerator(name = "cd_sequence", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "id")
     Integer id;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "actual_address")
     String actualAddress;
    @JoinColumn(name = "reg_address", referencedColumnName = "id")
    @ManyToOne
     City regAddress;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
     User userId;


    public ContactDetail(User userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ContactDetail{" +
                "id=" + id +
                ", phone_number='" + phoneNumber + '\'' +
                ", actualAddress='" + actualAddress + '\'' +
                ", reg_address=" + regAddress +
                '}';
    }
}
