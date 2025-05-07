/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */
class Department {   // Class to represent a department assigned to an employee.
    private DepartmentName name;  // Stores the name of the department using the enum

    public Department(DepartmentName name) {  // Constructor assigns the department name
        this.name = name;
    }

    public DepartmentName getName() { // Getter to retrieve the department name
        return name;
    }
}
