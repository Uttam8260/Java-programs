import java.util.*;
public class SumOfDigit {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=sc.nextInt();

        int sum=0;
        while(n > 0){
            sum += (n%10);
            n /=10;
            if(n == 0 && sum > 9){
                n=sum;
                sum=0;
                
            }
           
        }
        System.out.println("Sum of digit is1:"+sum);
    }
}
