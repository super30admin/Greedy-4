// Time Complexity : O(n) --> where n is the length of the input array
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (1007): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        // edge case
        if (A == null || A.length == 0) return 0;
        int result = check(A, B, B[0]); // check 5
        if (result != -1) return result;
        return check(A, B, A[0]);
    }
    
    private int check(int[] A, int[] B, int target) {
        int aRot = 0; int bRot = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != target && B[i] != target) return -1;
            else if (A[i] != target) aRot++;
            else if (B[i] != target) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}