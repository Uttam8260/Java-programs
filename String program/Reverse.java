
class Reverse {

    public static void main(String[] args) {
        String s = "Uttam Kumar Sahoo";
        String temp = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            temp = temp + s.charAt(i);
        }
        System.out.println("Reverse String is:" + temp);
    }
}
