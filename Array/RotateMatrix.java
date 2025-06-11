import java.util.*;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt(); // rows
        int n = sc.nextInt(); // columns

        int[][] matrix = new int[m][n];

        // Reading m x n matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        // Rotating 90 degrees anti-clockwise
        for (int col = n - 1; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                System.out.print(matrix[row][col]);
                // if (row != m - 1) System.out.print(" ");
            }
            System.out.println(); 
        }
    }
}
