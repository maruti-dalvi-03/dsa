import java.util.Scanner;
class HashTable {
    private int[] table;
    private boolean[] deleted;
    private int tableSize;
    // Constructor to initialize the hash table
    public HashTable(int size) {
        tableSize = size;
        table = new int[tableSize];
        deleted = new boolean[tableSize];
        for (int i = 0; i < tableSize; i++) {
            table[i] = Integer.MIN_VALUE; // Use Integer.MIN_VALUE to indicate empty slots
        }
    }
    // Hash function
    private int hashFunction(int key) {
        return key % tableSize;
    }
    // Insert a key into the hash table
    public void insert(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != Integer.MIN_VALUE && table[index] != Integer.MIN_VALUE && table[index] != key) {
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                System.out.println("Hash table is full! Cannot insert key: " + key);
                return;
            }
        }
        table[index] = key;
        deleted[index] = false;
        System.out.println("Inserted key " + key + " at index " + index);
    }
    // Search for a key in the hash table
    public boolean search(int key) {
        int index = hashFunction(key);
        int originalIndex = index;
        while (table[index] != Integer.MIN_VALUE) {
            if (table[index] == key && !deleted[index]) {
                return true;
            }
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                break;
            }
        }
        return false;
    }
    // Delete a key from the hash table
    public void delete(int key) {
        int index = hashFunction(key);
        int originalIndex = index;

        while (table[index] != Integer.MIN_VALUE) {
            if (table[index] == key && !deleted[index]) {
                deleted[index] = true;
                System.out.println("Deleted key " + key + " from index " + index);
                return;
            }
            index = (index + 1) % tableSize;
            if (index == originalIndex) {
                break;
            }
        }
        System.out.println("Key " + key + " not found!");
    }
    // Display the hash table
    public void display() {
        System.out.println("\nHash Table:");
        for (int i = 0; i < tableSize; i++) {
            if (table[i] != Integer.MIN_VALUE && !deleted[i]) {
                System.out.println("Index " + i + ": " + table[i]);
            } else {
                System.out.println("Index " + i + ": Empty");
            }
        }
    }
}

public class HashingWithLinearProbing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the hash table: ");
        int size = scanner.nextInt();
        HashTable hashTable = new HashTable(size);
        while (true) {
            System.out.println("\nHash Table Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Delete");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: // Insert
                    System.out.print("Enter the key to insert: ");
                    int keyToInsert = scanner.nextInt();
                    hashTable.insert(keyToInsert);
                    break;
                case 2: // Search
                    System.out.print("Enter the key to search: ");
                    int keyToSearch = scanner.nextInt();
                    if (hashTable.search(keyToSearch)) {
                        System.out.println("Key " + keyToSearch + " is present in the hash table.");
                    } else {
                        System.out.println("Key " + keyToSearch + " is not found in the hash table.");
                    }
                    break;
                case 3: // Delete
                    System.out.print("Enter the key to delete: ");
                    int keyToDelete = scanner.nextInt();
                    hashTable.delete(keyToDelete);
                    break;
                case 4: // Display
                    hashTable.display();
                    break;
                case 5: // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
