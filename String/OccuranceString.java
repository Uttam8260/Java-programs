
class OccuranceString {

    public static void main(String[] args) {
        String s = "Java is very easyyyy";
        char[] ch = s.toCharArray();
        //boolean[] visited = new boolean[ch.length];
        for (int i = 0; i < ch.length; i++) {
            // if (visited[i]) {
            //     continue;
            // }
            int count = 1;
            for (int j = i + 1; j < ch.length; j++) {
                if (ch[i] == ch[j]) {
                    count++;
                    ch[j] = '\u0000';
                }
            }
            if (ch[i] != '\u0000') {
                System.out.println(ch[i] + "=" + count);
            }
        }
    }
}
