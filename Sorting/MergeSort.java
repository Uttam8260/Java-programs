//Best time complexity= O(nlogn)
//Avg. time complexity=O(nlogn)
//Worst timne complexity=O(nlogn)
//Space complexity=O(n)

class MergeSort {

    public static void main(String[] args) {
        int[] a = {21, 23, 2, 3, 01, 210, 4, 33};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }

    public static void merge(int[] a, int[] b, int[] c) {
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                c[k++] = a[i++];
            } else {
                c[k++] = b[j++];
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }
    }

    public static void sort(int[] a) {
        if (a.length == 1) {
            return;
        }
        int[] left = new int[a.length / 2];
        int[] right = new int[a.length - left.length];
        System.arraycopy(a, 0, left, 0, left.length);
        for (int i = 0; i < right.length; i++) {
            right[i] = a[left.length + i];
        }
        sort(left);
        sort(right);
        merge(left, right, a);
    }

}
