import java.util.*;
 public class FindIndexofContainingCharacter{
    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.FindIndexofContainingCharacter(new String[]{"hello","nkpsd","ogtyg"},'o'));
        System.out.println(s.FindIndexofContainingCharacter(new String[]{"uttam","kumar"},'u'));
    }
    
}
class Solution{
        public List<Integer> FindIndexofContainingCharacter(String[] words, char x){

            List<Integer> l=new ArrayList<>();
            for(int i=0;i<words.length;i++){
                if(words[i].indexOf(x) !=-1){
                    l.add(i);
                }
            }
            return l;
        }
    }