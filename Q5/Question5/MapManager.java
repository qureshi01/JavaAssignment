package Question5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapManager {
    private Map<Integer, String> map;

    public MapManager() {
        map = new HashMap<>();
    }

    // Add a key-value pair to the map
    public void addKeyValuePair(int key, String value) {
        if (map.containsKey(key)) {
            System.out.println("Key already exists in the map. Updating the value.");
        }
        map.put(key, value);
        System.out.println("Key-value pair added: Key = " + key + ", Value = " + value);
    }

    // Remove a key-value pair from the map
    public void removeKeyValuePair(int key) {
        if (map.containsKey(key)) {
            String value = map.remove(key);
            System.out.println("Key-value pair removed: Key = " + key + ", Value = " + value);
        } else {
            System.out.println("Key not found in the map.");
        }
    }

    // Display all key-value pairs in the map
    public void displayKeyValuePairs() {
        if (map.isEmpty()) {
            System.out.println("The map is empty.");
        } else {
            System.out.println("Key-Value pairs in the map:");
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }
        }
    }

    public static void main(String[] args) {
        MapManager mapManager = new MapManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nMap Management System Menu:");
            System.out.println("1. Add a key-value pair");
            System.out.println("2. Remove a key-value pair");
            System.out.println("3. Display all key-value pairs");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    int key = scanner.nextInt();
                    System.out.print("Enter the value (String) : ");
                    String value = scanner.next();
                    mapManager.addKeyValuePair(key, value);
                    break;
                case 2:
                    System.out.print("Enter the key to remove: ");
                    int removeKey = scanner.nextInt();
                    mapManager.removeKeyValuePair(removeKey);
                    break;
                case 3:
                    mapManager.displayKeyValuePairs();
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
