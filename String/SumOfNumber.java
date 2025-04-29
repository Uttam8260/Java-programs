
class SumOfNumber {

    public static void main(String[] args) {
        String s = "uttam89260";
        int sum = 0;
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 48 && ch[i] <= 57) {
                sum += ch[i] - '0';
            }
        }
        System.out.println("sum no :" + sum);
    }
}
