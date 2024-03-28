package ca.dal.cs.csci3130.designpatterns.composite;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    String name;
    String department;
    int salary;
    List<Employee> subordinates;

    public Employee(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.subordinates = new ArrayList<>();
    }

    public void add(Employee employee) {
        this.subordinates.add(employee);
    }

    public void remove(Employee employee) {
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return this.subordinates;
    }

    public void show() {
        System.out.println(this.name + ", " + this.department + ", " + this.salary);
    }
}
