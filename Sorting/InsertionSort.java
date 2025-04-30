//Best time complexity:O(n)
//Avg time complexity:O(n^2)
//Worst time complexity:O(n^2)
//space complexity: O(1)

class InsertionSort {

    public static void main(String[] args) {
        int[] a = {3444, 42, 234, 56, 7, 2, 56, 2, 345, 55};
        sort(a);
        for (int n : a) {
            System.err.println(n);
        }
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = i - 1;
            int key = a[i];
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
    }
}
