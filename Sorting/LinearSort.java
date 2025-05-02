//Best time complexity: O(1)
//Avg. time complexity: O(n)
//Worst time complexity: O(n)
//Space complexity: O(1)

class LinearSort {

    public static void main(String[] args) {
        int[] a = {2, 4, 3, 9, 1, 2, 96, 65, 5};
        System.out.println(search(a, 5));
        System.out.println(search(a, 10));
    }

    public static int search(int[] a, int ele) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == ele) {
                return i;
            }

        }
        return -1;
    }
}
