package com.example.accessingdatamysql.Employee;

import com.example.accessingdatamysql.Department.Department;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name="EMPLOYEE")// This tells Hibernate to make a table out of this class
public class Employee {
    @Id
    @Column(name = "EMP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "EMP_F_NAME")
    private String name;

    @Column(name = "EMP_L_NAME")
    private String l_name;


    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "EMP_DEP",
            joinColumns = {@JoinColumn(name = "EMP_ID", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "DEP_ID", nullable = false)})
    @Column(nullable = false)
    private Set<Department> departments = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Employee() {
    }
}