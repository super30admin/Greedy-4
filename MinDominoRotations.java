// Time Complexity : The time complexity is O(n) where n is the length of the array
// Space Complexity : Te space complexity is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] A, int[] B) {

        int n = A.length;
        int max = iterate(A,B,A[0]);

        if(max != -1){
            return max;
        }

        return iterate(A,B,B[0]);
    }

    public int iterate(int[] A, int[] B,int target){

        int aRot = 0;
        int bRot = 0;

        for(int i=0;i<A.length;i++){
            //if the target is not present in both the arrays
            if(A[i] != target && B[i] != target) return -1;
            // if target is not in A, rotate A
            if(A[i] != target) aRot++;
            // if target is not in B, rotate B
            if(B[i] != target) bRot++;
        }

        return Math.min(aRot,bRot);
    }
}