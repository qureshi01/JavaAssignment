package Question5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListManager {
    private List<String> list;

    public ListManager() {
        list = new ArrayList<>();
    }

    // Add an element to the list
    public void addElement(String element) {
        list.add(element);
        System.out.println("Element added: " + element);
    }

    // Remove an element from the list
    public void removeElement(String element) {
        if (list.remove(element)) {
            System.out.println("Element removed: " + element);
        } else {
            System.out.println("Element not found in the list.");
        }
    }

    // Display all elements in the list
    public void displayElements() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        } else {
            System.out.println("Elements in the list:");
            for (String element : list) {
                System.out.println(element);
            }
        }
    }

    public static void main(String[] args) {
        ListManager listManager = new ListManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nList Management System Menu:");
            System.out.println("1. Add an element(String)");
            System.out.println("2. Remove an element(String)");
            System.out.println("3. Display all elements(String)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add (String) : ");
                    String addElement = scanner.next();
                    listManager.addElement(addElement);
                    break;
                case 2:
                    System.out.print("Enter the element to remove (String) : ");
                    String removeElement = scanner.next();
                    listManager.removeElement(removeElement);
                    break;
                case 3:
                    listManager.displayElements();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number from 1 to 4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
