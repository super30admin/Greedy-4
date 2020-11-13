// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int retVal = get_rot(A, B, A[0]);
        
        if(retVal != -1 || A[0] == B[0]){
            return retVal;
        }
        
        return get_rot(A, B, B[0]);
        
    }
    
    private int get_rot(int[] A, int B[], int val){
        int a_rot = 0;
        int b_rot = 0;
        
        for(int i=0; i<A.length; i++){
            if(A[i] != val && B[i]!= val){
                return -1;
            }else if(A[i] != val){
                a_rot++;
            }else if(B[i]!= val){
                b_rot++;
            }
        }
        return Math.min(a_rot, b_rot);
    }
}