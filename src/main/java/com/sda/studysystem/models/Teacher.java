package com.sda.studysystem.models;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Teacher model
 *
 * @author Marek Uibo
 */
@Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String idCode;

    @OneToOne(cascade = CascadeType.MERGE)
    private School school;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    private boolean isActive;

    private LocalDate joinDate;


}
