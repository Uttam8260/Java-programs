//Best time complexity: O(1)
//Avg. time complexity:O(logn)
//Worst time complexity: O(logn)
//Space complexity: O(1)

class BinarySort {

    public static void main(String[] args) {
        int[] a = {5, 6, 7, 9, 23};
        System.out.println(search(a, 4));
        System.out.println(search(a, 9));
    }

    public static int search(int[] a, int ele) {
        int start = 0;
        int end = a.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (ele == a[mid]) {
                return mid; 
            }else if (ele <= a[mid]) {
                end = mid - 1; 
            }else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
