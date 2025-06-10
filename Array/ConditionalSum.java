import java.util.*;

public class ConditionalSum{
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n=sc.nextInt();
            int k=sc.nextInt();
            int x=sc.nextInt();
            
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            Arrays.sort(arr);
            int sum=0;
            for(int i=x;i<n-k;i++){
                sum +=arr[i];
            }
            System.out.println(sum);
        }
    }
}