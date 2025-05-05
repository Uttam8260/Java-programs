
class TwoDArray {

    public static void main(String[] args) {
        int[][] a = {{2, 3, 4}, {5, 6, 7, 8}};
        for (int[] row : a) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}
