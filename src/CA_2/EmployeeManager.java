/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */

// This class controls the entire system: user input, menu handling,
// employee creation, file reading, sorting, searching, and random generation.

import java.util.*; // For List, ArrayList, Scanner, Random
import java.io.*; // For file reading (BufferedReader, FileReader)

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>(); // The main list storing all Employee objects
    private Scanner scanner = new Scanner(System.in); // Scanner for reading input from the user
    private Random random = new Random(); // Random generator for creating random names and selections
 
    public void run() { // Main method to start the system and loop through menu options
        boolean exit = false;
        
        while (!exit) { // Display menu options
            System.out.println("\nSelect an option:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option); // Print option number and name
            }
            int choice = scanner.nextInt(); // Read user choice as integer
            scanner.nextLine();

            switch (MenuOption.values()[choice - 1]) { // Handle menu logic using enum values
                case SORT -> sortEmployees();
                case SEARCH -> searchEmployee();
                case ADD -> addEmployee();
                case GENERATE -> generateRandomEmployees();
                case EXIT -> exit = true;
            }
        }
    }
    private void sortEmployees() {  // Function to read names from file, assign manager and department, and sort them
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Applicants_Form.txt")); // Read from file Applicants_Form.txt
            String line;
            employees.clear(); // Clear the existing list
            while ((line = reader.readLine()) != null) {  // Read each line (name) from the file and create an Employee object
                employees.add(new Employee(line.trim(),  // Employee name
                        new Manager(randomManagerType()), // Assign random manager type
                        new Department(randomDepartmentName()))); // Assign random department
            }
            SortUtil.mergeSort(employees);  // Sort employees using Merge Sort
            
            System.out.println("\nTop 20 Sorted Names:"); // Display first 20 sorted employees
            
            for (int i = 0; i < Math.min(20, employees.size()); i++) {
                System.out.println(employees.get(i));
            }
        } catch (IOException e) { // If file not found or reading fails
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private void searchEmployee() { // Function to search for an employee by name using Binary Search
        System.out.print("Enter employee name to search: ");
        
        String name = scanner.nextLine();
        SortUtil.mergeSort(employees); // Sort the list before searching (Binary Search requires sorted list)
        
        Employee found = SearchUtil.binarySearch(employees, name); // Search and display result
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }
    }
    private void addEmployee() {  // Allows manual addition of a new employee through input
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        ManagerType managerType = selectManagerType();  // Let user choose manager type
        DepartmentName departmentName = selectDepartmentName(); // Let user choose department

        Employee newEmp = new Employee(name, new Manager(managerType), new Department(departmentName)); // Create new employee with selections and add to the list
        employees.add(newEmp);
        System.out.println("\n" + name + " added successfully as " + managerType + " in " + departmentName);
    }
    private void generateRandomEmployees() { // Generate multiple random employees with random names, manager types, and departments
        System.out.print("How many employees to generate? ");
        int count = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int i = 0; i < count; i++) { // Random username
            String name = "User" + random.nextInt(1000);
            employees.add(new Employee(name, new Manager(randomManagerType()), new Department(randomDepartmentName())));
        }
        System.out.println(count + " employees generated.");
    }
    private ManagerType randomManagerType() { // Randomly pick a manager type from the enum
        return ManagerType.values()[random.nextInt(ManagerType.values().length)];
    }

    private DepartmentName randomDepartmentName() { // Randomly pick a department name from the enum
        return DepartmentName.values()[random.nextInt(DepartmentName.values().length)];
    }
    private ManagerType selectManagerType() { // Allow user to select a manager type from options
        System.out.println("Select Manager Type:");
        for (int i = 0; i < ManagerType.values().length; i++) {
            System.out.println((i + 1) + ". " + ManagerType.values()[i]);
        }
        int choice = scanner.nextInt(); // Consume newline
        scanner.nextLine();
        return ManagerType.values()[choice - 1];
    }

    private DepartmentName selectDepartmentName() { // Allow user to select a department name from options
        System.out.println("Select Department:");
        for (int i = 0; i < DepartmentName.values().length; i++) {
            System.out.println((i + 1) + ". " + DepartmentName.values()[i]);
        }
        int choice = scanner.nextInt(); // Consume newline
        scanner.nextLine();
        return DepartmentName.values()[choice - 1];
    }
}
