//Best time complexity= O(n^2)
//Avg. time complexity= O(n^2)
//Worst time complexity= O(n^2)
//Space complexity= O(1)

class SelectionSort {

    public static void main(String[] args) {
        int[] a = {23, 3, 412, 203, 45, 67, 99};
        sort(a);
        for (int n : a) {
            System.out.println(n);
        }
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[index]) {
                    index = j;
                }
            }
            if (i != index) {
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
        }
    }
}
