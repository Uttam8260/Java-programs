//Best time complexity= O(nlogn)
//Avg. time complexity= O(nlogn)
//Worst time complexity= O(n^2)
//Space complexity= O(logn)  average

public class QuickSort {

    public static void main(String[] args) {
        int[] a = {12, 32, 23232, 12, 2, 1, 4, 34};
        sort(a, 0, a.length - 1);
        for (int n : a) {
            System.out.println(n);
        }
    }

    public static void sort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = a[(start + end) / 2];
        while (start <= end) {
            while (a[i] < pivot) {
                i++;
            }
            while (a[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        if (start < j) {
            sort(a, start, j);
        }
        if (i < end) {
            sort(a, i, end);
        }
    }
}
