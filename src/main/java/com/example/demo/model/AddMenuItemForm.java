package com.example.demo.model;

import javax.validation.constraints.NotNull;

public class AddMenuItemForm {
    @NotNull
    private String lectorId;
    @NotNull
    private String departmentId;

    private Iterable<Lector> lectors;

    private Department department;

    public AddMenuItemForm(Iterable<Lector> lectors, Department department) {
        this.lectors = lectors;
        this.department = department;
//        this.departmentId = department.getId();
    }

    public String getLectorId() {
        return lectorId;
    }

    public void setLectorId(String lectorId) {
        this.lectorId = lectorId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public Iterable<Lector> getLectors() {
        return lectors;
    }

    public void setLectors(Iterable<Lector> lectors) {
        this.lectors = lectors;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "AddMenuItemForm{" +
                "lectorId='" + lectorId + '\'' +
                ", departmentId='" + departmentId + '\'' +
                ", lectors=" + lectors +
                ", department=" + department +
                '}';
    }
}
