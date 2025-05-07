/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */

// Class to represent a manager assigned to an employee.
class Manager {
    private ManagerType type; // Stores the type of manager using the enum

    public Manager(ManagerType type) { // Constructor sets the manager's type
        this.type = type;
    }

    public ManagerType getType() { // Getter to retrieve the manager type
        return type;
    }
}
