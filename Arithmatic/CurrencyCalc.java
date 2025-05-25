import java.util.Scanner;

public class CurrencyCalc{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        double amt=sc.nextDouble();

        if(amt >= 2000){
            int count2000=(int) (amt/2000);
            System.out.println("2000*"+count2000+"="+(2000*count2000));
            amt=amt % 2000;
        }
        if(amt >= 500){
            int count500=(int) (amt/500);
            System.out.println("500*"+count500+"="+(500*count500));
            amt=amt % 500;
        }
        if(amt >= 200){
            int count200=(int) (amt/200);
            System.out.println("200*"+count200+"="+(200*count200));
            amt=amt % 200;
        }
        if(amt >= 100){
            int count100=(int) (amt/100);
            System.out.println("100*"+count100+"="+(100*count100));
            amt=amt % 100;  
            System.out.println("Remaining amount:"+ amt);     
        }
    }
}
