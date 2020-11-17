    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
    Time Complexity for operators : o(n) .. n is the length of the array
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
    public int minDominoRotations(int[] A, int[] B) {
        
        int retVal = getCount(A,B,A[0]);
        
        if(retVal != -1 || A[0] == B[0]){
            return retVal;
        }
        return  getCount(A,B,B[0]);
    }
    
    private int getCount(int[] A, int[] B, int val){
        int a_count = 0;
        int b_count = 0;
        
        for(int i=0;i<A.length;i++){
            if(A[i] != val && B[i] != val)
                return -1;
            else if(A[i] != val){
                a_count += 1;
            }else if(B[i] != val){
                b_count += 1; 
            }
        }
        
        return Math.min(a_count,b_count);
    }
}