import java.util.Scanner;
class Node {
    int coefficient, exponent;
    Node next;
    Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}
class Polynomial {
    Node head;
    // Insert a term in the polynomial in sorted order by exponent
    public void insertTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);

        if (head == null || head.exponent < exponent) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.exponent > exponent) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    // Display the polynomial
    public void display() {
        if (head == null) {
            System.out.println("0");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            if (current.next != null) System.out.print(" + ");
            current = current.next;
        }
        System.out.println();
    }
    // Add two polynomials
    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        Node t1 = p1.head, t2 = p2.head;

        while (t1 != null && t2 != null) {
            if (t1.exponent == t2.exponent) {
                int sumCoeff = t1.coefficient + t2.coefficient;
                if (sumCoeff != 0) {
                    result.insertTerm(sumCoeff, t1.exponent);
                }
                t1 = t1.next;
                t2 = t2.next;
            } else if (t1.exponent > t2.exponent) {
                result.insertTerm(t1.coefficient, t1.exponent);
                t1 = t1.next;
            } else {
                result.insertTerm(t2.coefficient, t2.exponent);
                t2 = t2.next;
            }
        }
        // Add remaining terms
        while (t1 != null) {
            result.insertTerm(t1.coefficient, t1.exponent);
            t1 = t1.next;
        }
        while (t2 != null) {
            result.insertTerm(t2.coefficient, t2.exponent);
            t2 = t2.next;
        }

        return result;
    }
}
public class PolynomialAddition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Create two polynomials
        Polynomial p1 = new Polynomial();
        Polynomial p2 = new Polynomial();
        // Input first polynomial
        System.out.println("Enter the number of terms for the first polynomial:");
        int n1 = scanner.nextInt();
        System.out.println("Enter terms (coefficient and exponent):");
        for (int i = 0; i < n1; i++) {
            int coeff = scanner.nextInt();
            int exp = scanner.nextInt();
            p1.insertTerm(coeff, exp);
        }
        // Input second polynomial
        System.out.println("Enter the number of terms for the second polynomial:");
        int n2 = scanner.nextInt();
        System.out.println("Enter terms (coefficient and exponent):");
        for (int i = 0; i < n2; i++) {
            int coeff = scanner.nextInt();
            int exp = scanner.nextInt();
            p2.insertTerm(coeff, exp);
        }
        // Display input polynomials
        System.out.println("First Polynomial:");
        p1.display();
        System.out.println("Second Polynomial:");
        p2.display();
        // Add the polynomials
        Polynomial result = Polynomial.add(p1, p2);
       // Display result
        System.out.println("Resultant Polynomial after addition:");
        result.display();
    }
}
