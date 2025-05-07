/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CA_2;

/**
 *
 * @author roger
 */
import java.util.*;
import java.io.*;

class EmployeeManager {
    private List<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nSelect an option:");
            for (MenuOption option : MenuOption.values()) {
                System.out.println(option.ordinal() + 1 + ". " + option);
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (MenuOption.values()[choice - 1]) {
                case SORT -> sortEmployees();
                case SEARCH -> searchEmployee();
                case ADD -> addEmployee();
                case GENERATE -> generateRandomEmployees();
                case EXIT -> exit = true;
            }
        }
    }
    private void sortEmployees() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Applicants_Form.txt"));
            String line;
            employees.clear();
            while ((line = reader.readLine()) != null) {
                employees.add(new Employee(line.trim(),
                        new Manager(randomManagerType()),
                        new Department(randomDepartmentName())));
            }
            SortUtil.mergeSort(employees);
            System.out.println("\nTop 20 Sorted Names:");
            for (int i = 0; i < Math.min(20, employees.size()); i++) {
                System.out.println(employees.get(i));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    private void searchEmployee() {
        System.out.print("Enter employee name to search: ");
        String name = scanner.nextLine();
        SortUtil.mergeSort(employees);
        Employee found = SearchUtil.binarySearch(employees, name);
        if (found != null) {
            System.out.println("Found: " + found);
        } else {
            System.out.println("Employee not found.");
        }
    }
    private void addEmployee() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        ManagerType managerType = selectManagerType();
        DepartmentName departmentName = selectDepartmentName();

        Employee newEmp = new Employee(name, new Manager(managerType), new Department(departmentName));
        employees.add(newEmp);
        System.out.println("\n" + name + " added successfully as " + managerType + " in " + departmentName);
    }
    private void generateRandomEmployees() {
        System.out.print("How many employees to generate? ");
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String name = "User" + random.nextInt(1000);
            employees.add(new Employee(name, new Manager(randomManagerType()), new Department(randomDepartmentName())));
        }
        System.out.println(count + " employees generated.");
    }
