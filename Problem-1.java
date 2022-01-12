// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        
        int src = 0;
        int tgt = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        
        for(int i=0; i < source.length(); i++) {
            
            set.add(source.charAt(i));
            
        }
        
        while(tgt < target.length()) {
            
            if(!set.contains(target.charAt(tgt))) {
                
                return -1;
                
            }
            if(source.charAt(src) == target.charAt(tgt)) {
                
                tgt++;
                
            }    
            
            src++;
            if(src == source.length()) {
                count++;
                src=0;
            }
        }
        
        if(src != 0) {
            count++;
        }
        return count;
    }
}