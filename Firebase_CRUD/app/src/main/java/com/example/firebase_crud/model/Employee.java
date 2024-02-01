package com.example.firebase_crud.model;

import java.io.Serializable;

//needs to be serializable to pass on the data from one page to another
public class Employee implements Serializable {

    public static final String TAG = "Employee";
    private String name;
    private String position;
    private String department;

    //empty constructor for firebase
    public Employee() {
    }


    //getters and setters for all the fields
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
