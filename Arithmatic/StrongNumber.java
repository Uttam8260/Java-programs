import java.util.*;
public class StrongNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int num=sc.nextInt();
        int originalNum=num;
        int sum=0;

        while(num > 0){
            int digit = num%10;
            sum += factorial(digit);
            num=num/10;
        }
        if(sum==originalNum){
            System.out.println(originalNum + " is a strong number");
        }
        else{
            System.out.println(originalNum + " is not a strong number");
        }
    }
    static int factorial(int n){
        int fact=1;
        for (int i = 2; i <= n; i++) {
            fact=fact*i;
        }
        return fact;
    }
}