// Time Complexity : O(n*m) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shortestWay(String source, String target) {
        
        int sLength = source.length();
        int tLength = target.length();
        
        int tp = 0;
        int sp = 0;
        int res = 0;
        
        while(tp < tLength){
            sp = 0;
            int curr = tp;
            
            while(tp < tLength && sp < sLength){
                if(source.charAt(sp) == target.charAt(tp)){
                    tp++;
                }
                sp++;
            }
            if(curr == tp){
                return -1;
            }
            
            res++;
        }
        return res;
    }
}

