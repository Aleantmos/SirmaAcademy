package com.exam.pairidentifier.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  @ManyToMany(mappedBy = "employees")
  //  private List<Project> projects;

    @Column(name = "employee_id")
    private Long employeeId;

    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
        //this.projects = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   //public List<Project> getProjects() {
   //    return projects;
   //}
   //   public void setProject(List<Project> projects) {
   //    this.projects = projects;
   //}

}
