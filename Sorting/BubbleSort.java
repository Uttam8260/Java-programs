//Best time complexity: O(n)
//Avg time complexity:O(n^2)
//Worst time complexity:O(n^2)
//space complexity:O(1)

class BubbleSort {
    public static void main(String[] args) {
        int[] a = {13, 41, 2, 123, 567, 324, 542, 67, 88};
        sort(a);
        for (int n : a) {
            System.err.println(n);
        }
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
}
