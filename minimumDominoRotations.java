// Time Complexity : O(n) where n is the number of elements in array A or B
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class minimumDominoRotations {
    public int minDominoRotations(int[] A, int[] B) {
        int ans = check(A, B, A[0]);
        if (ans != -1) return ans;
        return check(A, B, B[0]);
    }
    private int check(int[] A, int[] B, int x) {
        int aRot = 0, bRot = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != x && B[i] != x) {
                return -1;
            }
            else if (A[i] != x) aRot++; 
            else if (B[i] != x) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}