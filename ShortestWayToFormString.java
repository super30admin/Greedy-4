//Time Complexity O(M*N)
//Space Complexity O(M)
//Leetcode tested

public class ShortestWayToFormString {
    public int shortestWay(String source,String target){
        int numSubsequences = 0;
        String remaining = target;
        while (remaining.length() > 0){
            StringBuilder subSequence = new StringBuilder();
            int i = 0;
            int j = 0;
            while (i < source.length() && j < remaining.length()){
                if(source.charAt(i++) == remaining.charAt(j)){
                    subSequence.append(remaining.charAt(j++));
                }
            }
            if(subSequence.length() == 0){
                return -1;
            }
            numSubsequences++;
            remaining = remaining.substring(subSequence.length());
        }
        return numSubsequences;
    }
}
