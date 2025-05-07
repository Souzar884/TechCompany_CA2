/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */

// Class representing an individual employee.
public class Employee {
private String name;    // Employee's name
    private Manager manager; // Assigned manager (as an object)
    private Department department; // Assigned department (as an object)

    public Employee(String name, Manager manager, Department department) {  // Constructor sets all three values at creation
        this.name = name;
        this.manager = manager;
        this.department = department;
    }
    
     // Getter methods for each field
    public String getName() {
        return name;
    }

    public Manager getManager() {
        return manager;
    }

    public Department getDepartment() {
        return department;
    }

    // Returns a readable description of the employee
    public String toString() {
        return name + " | Manager: " + manager.getType() + " | Department: " + department.getName();
    }
}
