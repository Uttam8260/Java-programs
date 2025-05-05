
class Adding2dArray {

    public static void main(String[] args) {
        int[][] a = {{2, 4, 5}, {4, 6, 7}, {8, 9, 10}};
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i][i];
            if (a.length % 2 != 0 && i == a.length / 2) {
                continue;

            }
            sum += a[i][a.length - 1 - i];
            System.out.println(sum);

        }
    }
}
