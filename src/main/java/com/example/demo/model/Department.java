package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "departments", uniqueConstraints = {
        @UniqueConstraint(columnNames = "department_id"),
        @UniqueConstraint(columnNames = "department_name") })
public class Department {
    @Id
    @Column(name = "department_id")
    private String id;
    @Column(name = "department_name", unique = true)
    private String departmentName;
//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "departments")
    @ManyToMany
    private List<Lector> lectors;

    public Department() {
        this.lectors = new ArrayList<>();
        this.id = UUID.randomUUID().toString();
    }

    public Department(String departmentName) {
        this();
        this.departmentName = departmentName;
    }

    public Department(String id, String departmentName) {
        this(departmentName);
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

    public List<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(List<Lector> lectors) {
        this.lectors = lectors;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id='" + id + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", lectors=" + lectors +
                '}';
    }
}
