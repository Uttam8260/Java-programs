
class Exp2 {

    public static void main(String[] args) {

        System.err.println("main start");
        try {
            String s = "uttamm";
            //char[] ch=s.toCharArray();
            System.out.println(s.charAt(8));
        } //     catch (Exception e) {
        //     System.out.println("Arithmatic block");
        //    }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception handled");
        }
    }
}
