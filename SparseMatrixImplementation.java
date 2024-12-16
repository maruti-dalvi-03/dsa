import java.util.Scanner;
class Node {
    int row, col, value;
    Node next;

    Node(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.next = null;
    }
}
class SparseMatrix {
    Node head;
    // Add a non-zero element to the sparse matrix
    public void addElement(int row, int col, int value) {
        Node newNode = new Node(row, col, value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }
    // Display the sparse matrix as a list of non-zero elements
    public void displayAsList() {
        if (head == null) {
            System.out.println("The sparse matrix is empty.");
            return;
        }
        System.out.println("Row\tCol\tValue");
        Node current = head;
        while (current != null) {
            System.out.println(current.row + "\t" + current.col + "\t" + current.value);
            current = current.next;
        }
    }
    // Display the full matrix for visualization
    public void displayAsMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Node current = head;
        while (current != null) {
            matrix[current.row][current.col] = current.value;
            current = current.next;
        }
        System.out.println("Full Matrix Representation:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
public class SparseMatrixImplementation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Input matrix dimensions
        System.out.println("Enter the number of rows and columns of the matrix:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        // Create a sparse matrix
        SparseMatrix sparseMatrix = new SparseMatrix();
        // Input number of non-zero elements
        System.out.println("Enter the number of non-zero elements:");
        int nonZeroElements = scanner.nextInt();
        // Input non-zero elements
        System.out.println("Enter the row, column, and value for each non-zero element:");
        for (int i = 0; i < nonZeroElements; i++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();
            sparseMatrix.addElement(row, col, value);
        }
        // Display the sparse matrix
        System.out.println("\nSparse Matrix Representation (as list):");
        sparseMatrix.displayAsList();
        // Display the full matrix for visualization
        System.out.println("\nSparse Matrix Representation (as matrix):");
        sparseMatrix.displayAsMatrix(rows, cols);
    }
}
