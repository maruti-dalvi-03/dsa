import java.util.Scanner;
class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}
class BST {
    Node root;
    // a) Insert a node in BST
    public void insert(int value) {
        root = insertRec(root, value);
    }
    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }
        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }
        return root;
    }
    // b) Delete a node from BST
    public void delete(int value) {
        root = deleteRec(root, value);
    }
    private Node deleteRec(Node root, int value) {
        if (root == null) return root;
        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {
            // Node with one or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            // Node with two children: get the inorder successor
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }
    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    // c) Find height of BST
    public int findHeight() {
        return heightRec(root);
    }
    private int heightRec(Node root) {
        if (root == null) return -1; // Height of an empty tree is -1
        return Math.max(heightRec(root.left), heightRec(root.right)) + 1;
    }
    // d) Perform Inorder Traversal
    public void inorder() {
        System.out.println("Inorder Traversal:");
        inorderRec(root);
        System.out.println();
    }
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    // e) Perform Preorder Traversal
    public void preorder() {
        System.out.println("Preorder Traversal:");
        preorderRec(root);
        System.out.println();
    }
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }
    // f) Perform Postorder Traversal
    public void postorder() {
        System.out.println("Postorder Traversal:");
        postorderRec(root);
        System.out.println();
    }
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.data + " ");
        }
    }
    // g) Find maximum value in BST
    public int findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }
        return maxValue(root);
    }
    private int maxValue(Node root) {
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
}
public class BSTOperations {
    public static void main(String[] args) {
        BST bst = new BST();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Delete");
            System.out.println("3. Find Height");
            System.out.println("4. Inorder Traversal");
            System.out.println("5. Preorder Traversal");
            System.out.println("6. Postorder Traversal");
            System.out.println("7. Find Maximum");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    // Insert
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println(value + " inserted.");
                }
                case 2 -> {
                    // Delete
                    System.out.print("Enter value to delete: ");
                    int value = scanner.nextInt();
                    bst.delete(value);
                    System.out.println(value + " deleted (if present).");
                }
                case 3 -> // Find Height
                    System.out.println("Height of the tree: " + bst.findHeight());
                case 4 -> // Inorder Traversal
                    bst.inorder();
                case 5 -> // Preorder Traversal
                    bst.preorder();
                case 6 -> // Postorder Traversal
                    bst.postorder();

                case 7 -> {
                    // Find Maximum
                    try {
                        System.out.println("Maximum value in the tree: " + bst.findMax());
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 8 -> {
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
