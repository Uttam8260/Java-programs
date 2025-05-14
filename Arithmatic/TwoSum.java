import java.util.*;
public class TwoSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a number");
        int n=sc.nextInt();
       int[] nums=new int[n];
       System.out.println("Enter"+ n +"Elements");
       for(int i=0;i<n;i++){
        nums[i]=sc.nextInt();
       }
       System.out.println("Enter target value");
       int target=sc.nextInt();
       int[] result= twoSum(nums,target);
       if(result.length ==2){
        System.out.println("Indices: "+result[0]+" and "+result[1]);
       }else{
        System.out.println("No valid pair found");
       }
       
    }  
    public static int[] twoSum(int[] nums,int target){
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{
                    map.get(complement),i
                };
            }
           map.put(nums[i],i);
        }
        return new int[0];
    }
}
