import java.util.Scanner;
public class Addition_Matrix {
    public static void main(String[] args) {
        System.out.println("Enter the Numbers of rows and columns for the matrices:");
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] m1 = new int[rows][cols];
        int[][] m2 = new int[rows][cols];
        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at position (" + i + "," + j + "): ");
                m1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Element at position (" + i + "," + j + "): ");
                m2[i][j] = sc.nextInt();
            }
        }

        // Add the two matrices
        int[][] sum = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = m1[i][j] + m2[i][j];
            }
        }

        // Print the sum matrix
        System.out.println("Sum of the two matrices:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
}
