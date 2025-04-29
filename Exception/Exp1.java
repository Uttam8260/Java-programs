
class Exp1 {

    public static void main(String[] args) {
        System.err.println("main start");
        try {
            System.err.println(10 / 0);//Arithmatic exception
            System.err.println(10 % 0);//Arithmatic exception
            System.err.println(10 / 0.0);//Infinity
        } catch (Exception e) {

            System.err.println("Exception handled");
            //e.printStackTrace();
        }
        System.err.println("main end");
    }
}
