package Question5;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetManager {
    private Set<String> set;

    public SetManager() {
        set = new HashSet<>();
    }

    // Add an element to the set
    public void addElement(String element) {
        if (set.add(element)) {
            System.out.println("Element added: " + element);
        } else {
            System.out.println("Element already exists in the set.");
        }
    }

    // Remove an element from the set
    public void removeElement(String element) {
        if (set.remove(element)) {
            System.out.println("Element removed: " + element);
        } else {
            System.out.println("Element not found in the set.");
        }
    }

    // Display all elements in the set
    public void displayElements() {
        if (set.isEmpty()) {
            System.out.println("The set is empty.");
        } else {
            System.out.println("Elements in the set:");
            for (String element : set) {
                System.out.println(element);
            }
        }
    }

    public static void main(String[] args) {
        SetManager setManager = new SetManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSet Management System Menu:");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to add (String) : ");
                    String addElement = scanner.next();
                    setManager.addElement(addElement);
                    break;
                case 2:
                    System.out.print("Enter the element to remove (String) : ");
                    String removeElement = scanner.next();
                    setManager.removeElement(removeElement);
                    break;
                case 3:
                    setManager.displayElements();
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
