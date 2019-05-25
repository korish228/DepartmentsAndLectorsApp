package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "departments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "department_id"),
        @UniqueConstraint(columnNames = "department_name") })
public class Department {
    @Id
    @Column(name = "department_id")
    private String id;
    @Column(name = "department_name", unique = true)
    @NotNull
    @Size(min = 2)
    private String departmentName;


    @ManyToOne
    private Lector headOfDepartment;

    @ManyToMany
    private Set<Lector> lectors;

    public Department() {
        this.lectors = new HashSet<>();
        this.id = UUID.randomUUID().toString();
    }

    public Department(String departmentName, Lector headOfDepartment) {
        this();
        this.departmentName = departmentName;
        this.headOfDepartment = headOfDepartment;
    }

    public Department(String id, String departmentName,Lector headOfDepartment) {
        this(departmentName, headOfDepartment);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Lector getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Lector headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Set<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Set<Lector> lectors) {
        this.lectors = lectors;
    }

    public void addItem(Lector lector) {
        this.lectors.add(lector);
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", headOfDepartment=" + headOfDepartment +
                ", lectors=" + lectors +
                '}';
    }
}
