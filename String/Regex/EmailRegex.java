import java.util.regex.*;
class EmailRegex{
    public static void main(String[] args) {
        String email="sahouu12@gmail.com";
        String exp="^[a-zA-Z0-9._%+-]+@[a-z0-9A-Z]+\\.[a-zA-Z0-9]{2,}$";
        Pattern p=Pattern.compile(exp);
        Matcher m = p.matcher(email);
        if(m.matches()){
            System.out.println("valid email id");
        }
        else {
            System.out.println("Invalid email id");
        }
    }
}