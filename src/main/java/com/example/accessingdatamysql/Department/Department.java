package com.example.accessingdatamysql.Department;


import com.example.accessingdatamysql.Employee.Employee;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
@Table(name ="DEPARTMENT" )

public class Department {


   @Id
   @Column(name = "DEP_ID")
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long depId;

    @Column(name = "DEP_NAME")
    private String name;

    @Column(name = "DEP_HEAD")
    private String depHead;

    @ManyToMany()
    private Set<Employee> employee = new HashSet<>();

    public Department(String name, String depHead)
    {   this.name = name;
        this.depHead = depHead;
    }
    public Department(){
        super();
    }


    public Long getId() {
        return depId;
    }
   public void setId(Long id) {
       this.depId = id;
   }

   public String getName(){
        return this.name;
   }

   public void  setName(String name){
        this.name = name;
    }

    public String getDepHead(){
        return this.depHead;
    }



    public void setDepHead(String depHead){
        this.depHead = depHead;
    }

    public Set<Employee> getEmployee(){
        return employee;
    }

    public void setEmployee(Set<Employee> employee)
    {
        this.employee=employee;
    }
}

