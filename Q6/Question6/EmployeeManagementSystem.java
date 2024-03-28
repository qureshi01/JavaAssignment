package Question6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Employee {
    private String employeeId;
    private String name;
    private String department;
    private double salary;

    public Employee(String employeeId, String name, String department, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters and setters
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

public class EmployeeManagementSystem {
    private Map<String, Employee> employeeMap;

    public EmployeeManagementSystem() {
        employeeMap = new HashMap<>();
    }

    // Add new employee
    public void addEmployee(String employeeId, String name, String department, double salary) {
        if (employeeMap.containsKey(employeeId)) {
            System.out.println("Employee with ID " + employeeId + " already exists.");
        } else {
            Employee employee = new Employee(employeeId, name, department, salary);
            employeeMap.put(employeeId, employee);
            System.out.println("Employee added successfully: " + employee);
        }
    }

    // Update employee details
    public void updateEmployee(String employeeId, String name, String department, double salary) {
        if (employeeMap.containsKey(employeeId)) {
            Employee employee = employeeMap.get(employeeId);
            employee.setName(name);
            employee.setDepartment(department);
            employee.setSalary(salary);
            System.out.println("Employee details updated successfully: " + employee);
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    // Delete an employee
    public void deleteEmployee(String employeeId) {
        if (employeeMap.containsKey(employeeId)) {
            employeeMap.remove(employeeId);
            System.out.println("Employee with ID " + employeeId + " deleted successfully.");
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    // Display all employees
    public void displayEmployees() {
        System.out.println("List of all employees:");
        for (Employee employee : employeeMap.values()) {
            System.out.println(employee);
        }
    }

    // Search for an employee by ID
    public void searchEmployee(String employeeId) {
        if (employeeMap.containsKey(employeeId)) {
            System.out.println("Employee details:");
            System.out.println(employeeMap.get(employeeId));
        } else {
            System.out.println("Employee with ID " + employeeId + " not found.");
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem empSystem = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add new employee");
            System.out.println("2. Update employee details");
            System.out.println("3. Delete an employee");
            System.out.println("4. Display all employees");
            System.out.println("5. Search for an employee");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter employee ID: ");
                    String employeeId = scanner.next();
                    System.out.print("Enter employee name: ");
                    String name = scanner.next();
                    System.out.print("Enter employee department: ");
                    String department = scanner.next();
                    System.out.print("Enter employee salary: ");
                    double salary = scanner.nextDouble();
                    empSystem.addEmployee(employeeId, name, department, salary);
                    break;
                case 2:
                    System.out.print("Enter employee ID to update: ");
                    String updateId = scanner.next();
                    System.out.print("Enter updated name: ");
                    String updateName = scanner.next();
                    System.out.print("Enter updated department: ");
                    String updateDept = scanner.next();
                    System.out.print("Enter updated salary: ");
                    double updateSalary = scanner.nextDouble();
                    empSystem.updateEmployee(updateId, updateName, updateDept, updateSalary);
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    String deleteId = scanner.next();
                    empSystem.deleteEmployee(deleteId);
                    break;
                case 4:
                    empSystem.displayEmployees();
                    break;
                case 5:
                    System.out.print("Enter employee ID to search: ");
                    String searchId = scanner.next();
                    empSystem.searchEmployee(searchId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 6.");
            }
        }
    }
}
