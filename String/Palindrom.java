
// class Palindrom {
//     public static void main(String[] args) {
//         String s = "malayalam";
//         System.err.println(isPalindrom(s));
//     }
//     public static boolean isPalindrom(String s) {
//         int i = 0;
//         int j = s.length() - 1;
//         while (i <= j) {
//             if (s.charAt(i) != s.charAt(j)) {
//                 return false;
//             }
//             i++;
//             j--;
//         }
//         return true;
//     }
// }
class Palindrom {

    public static void main(String[] args) {
        String s = "madam";
        if (isPalindrom(s)) {
            System.err.println("palindrom String");
        } else {
            System.err.println("Not a palindrom String");
        }
    }

    public static boolean isPalindrom(String s) {
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp += s.charAt(i);
        }
        return temp.equals(s);
    }
}
