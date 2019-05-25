package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "lectos", uniqueConstraints = {
        @UniqueConstraint(columnNames = "lector_id")
})
public class Lector {
    @Id
    @Column(name = "lector_id")
    private String id;
//    @Min(3)
    @NotNull
    @Size(min = 2)
    private String firstName;
//    @Email
//    @Column(unique = true)
//    @Min(3)
    @NotNull
    @Size(min = 2)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "headOfDepartment")
    private Set<Department> headsDepartments;

    @ManyToMany(mappedBy = "lectors")
    private Set<Department> departments;

    @NotNull
    private Double salary;

    private Degree degree;

    public void addHeadOfDepartment(Department department) {
        this.headsDepartments.add(department);
    }

    public static  enum  Degree {
        ASSISTANT("assistant"),
        ASSOSIATE_PROFESSOR("associate professor"),
        PROFESSOR("professor");

        private final String degree;

        Degree(String degree) {
            this.degree = degree;
        }

        public String getDegree() {
            return degree;
        }
    }

    public Lector() {
        this.headsDepartments = new HashSet<>();
        this.id = UUID.randomUUID().toString();
        this.departments = new HashSet<>();
    }

    public Lector(String firstName, String lastName, Degree degree, Double salary) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.degree = degree;
    }

    public Lector(String id, String firstName, String lastName, Degree degree, Double salary) {
        this(firstName, lastName, degree, salary);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Set<Department> getHeadsDepartments() {
        return headsDepartments;
    }

    public void setHeadsDepartments(Set<Department> headsDepartments) {
        this.headsDepartments = headsDepartments;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}