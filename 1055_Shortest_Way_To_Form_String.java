    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/shortest-way-to-form-string/
    Time Complexity for operators : o(n*m) .. n is the length of the array
    Extra Space Complexity for operators : o(1) 
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 
    */ 

class Solution {
    public int shortestWay(String source, String target) {
        
        int s = source.length();
        int t = target.length();
        
        int TP = 0;
        int SP = 0;
        int output = 0;
        
        while(TP < t){
            SP = 0;
            int curr = TP;
            
            while(TP < t && SP < s){
                if(source.charAt(SP) == target.charAt(TP)){
                    
                    TP += 1;
                }
                SP += 1;
            }
            
            if(curr == TP){
                return -1;
            }
            
            output += 1;
        }
        return output;
    }
}