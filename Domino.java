// Time Complexity :O(n) where m is the length of source and n is the length of the target.
// Space Complexity :O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int result = helper(A,B,A[0]);
        if(result!=-1) return result;
        return helper(A,B,B[0]);
    }
    private int helper(int[] A, int[] B, int X)
    {
        int aCount = 0;
        int bCount = 0;
        for(int i = 0 ; i <A.length;i++)
        {
            if(A[i]!=X && B[i]!=X)
            {
                return -1;
            }
            else if(A[i]!=X) aCount++;
            else if(B[i]!=X) bCount++;
        }
        return Math.min(aCount,bCount);
    }
}