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
