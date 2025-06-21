

public class practice{
    public static void main(String[] args) {
       int[] a= {12,45,23,14,2,132};
        sort(a);
        for(int n:a){
            System.err.println(n);
        }
    }
    public static void sort(int[] a){
        for(int i=0;i<a.length;i++){
            for(int j=i+1;j<a.length;i++){
                if(a[j]>a[j+1]){
                    int temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
    }
}