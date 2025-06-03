import java.util.regex.*;
import java.util.regex.Pattern;
class Numberregex{
    public static void main(String[] args) {
        String s="8217388961";
        String exp="[6-9][0-9]{9}";
        Pattern p=Pattern.compile(exp);
        Matcher m=p.matcher(s);
        if(m.matches()){
            System.out.println("Valid number");
        }
        else{
            System.out.println("Invalid number");
        }
    }
}