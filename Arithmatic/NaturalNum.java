
class NaturalNum {

    public static void main(String[] args) {
        System.out.println("Enter a number");
        int i = 1;
        int n = 100;
        int sum = 0;
        while (i <= n) {
            sum = sum + i;
            i++;
        }
        System.out.println(sum);
    }
}
