
class Replace {

    public static void main(String[] args) {
        String s = "uttam kuamr sahoo";
        replace(s);
    }

    public static void replace(String s) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    ch[j] = '$';
                }
            }
        }
        System.out.println(ch);
    }
}
