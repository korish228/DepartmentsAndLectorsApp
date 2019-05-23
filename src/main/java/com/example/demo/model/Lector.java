package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "lector", uniqueConstraints = {
        @UniqueConstraint(columnNames = "lector_id")
})
public class Lector {
    @Id
    @Column(name = "lector_id")
    private String id;
    private String firstName;
//    @Email
//    @Column(unique = true)
    private String lastName;

    @ManyToMany(mappedBy = "lectors")
    List<Department> departments;

    private Integer salary;

    private Degree degree;

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
        this.id = UUID.randomUUID().toString();
        this.departments = new ArrayList<>();
    }

    public Lector(String firstName, String lastName, Degree degree, Integer salary) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.degree = degree;
    }

    public Lector(String id, String firstName, String lastName, Degree degree, Integer salary) {
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

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}