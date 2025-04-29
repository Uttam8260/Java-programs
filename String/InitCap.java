
class InitCap {

    public static void main(String[] args) {
        String s = "hello how are u?";
        initcap(s);
    }

    public static void initcap(String s) {
        char[] ch = s.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == ' ') {
                if (ch[i + 1] >= 'a' && ch[i + 1] <= 'z') {
                    ch[i + 1] = (char) (ch[i + 1] - 32);
                }
            }
        }
        System.err.println(ch);
    }
}
