// Time Complexity : O(m * n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        
        int sl = source.length(), tl = target.length();
        
        if(sl == 0 || source == null) return -1;
        
        int sp = 0, tp = 0, count = 0;
        
        while(tp < tl) {
            
            int curr = tp;
            sp = 0;

            while(sp < sl && tp < tl) {
                
                if(source.charAt(sp) == target.charAt(tp)) {
                    tp++;
                }
                sp++;
            }
            count++;
            
            if(tp == curr) {
                return -1;
            }
            
        }
        
        return count;
    }
}