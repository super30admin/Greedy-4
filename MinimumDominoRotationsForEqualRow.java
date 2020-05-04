// Time Complexity : O(n) n-> length of the domino array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//Approach:
// To make all the numbers same after rotation, it has to be present in either domino A or B or both. 
// So, we can consider any number as starting number to check in the domino array for possible rotations.
// If the number to be checked is not available in top row, bottom count will be incremented and vice-versa.
// If selected number from row A results in -1, a number will be selected and checked from domino row B.

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // edge case
        if(A== null || B == null)
            return -1;
        
        if(A.length != B.length)
            return -1;
        
        int result = countCheck(A, B, A[0]);
        if(result == -1)
            return countCheck(A, B, B[0]);
        return result;
    }
    
    private int countCheck(int[] A, int[] B, int num) {
        int top = 0, bottom = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] != num && B[i] != num)
                return -1;
            if(A[i] != num)
                bottom++;
            if(B[i] != num)
                top++;
        }
        return Math.min(top, bottom);
    }
}
