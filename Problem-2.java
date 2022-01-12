// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int result = helper(tops,bottoms, tops[0]);
        
        
        if(result != -1) {
            
            return result;
            
        }
        
        result = helper(tops,bottoms, bottoms[0]);
        
        return result;
        
    }
    
    private int helper(int[] tops, int[] bottoms, int target) {
        
        int topCount = 0;
        int bottomCount = 0;
        
        for(int i=0;i<tops.length;i++) {
            
            if(tops[i] != target && bottoms[i] != target) {
                 
                return -1;
            
            }
            else if(tops[i] != target && bottoms[i] == target) {
                
                topCount++;
            
            }else if(tops[i] == target && bottoms[i] != target) {
                
                bottomCount++;
                
            }
        }
        
        return Math.min(topCount,bottomCount);
    }
}