import java.util.*;
class Automorphic{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=sc.nextInt();
        int square=n*n;
        String num=String.valueOf(n) ;
        String str=String.valueOf(square);

        if(str.endsWith(num)){
            System.out.println(n + " is an Automorphic number");;
        }
        else{
            System.out.println(n+" is not an automorphic number");
        }
    }
}