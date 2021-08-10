// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    private int check(int[] A, int[] B, int n, int x){
        int rA = 0;
        int rB = 0;
        for(int i = 0 ; i < n ; i++){
            if(A[i]!=x && B[i]!=x) return -1;
            else if(A[i]!= x)  rA++;
            else if(B[i]!=x) rB++;
        }
        return Math.min(rA,rB);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        int result = check(tops,bottoms,n,tops[0]);
        if(result == -1) return check(tops,bottoms,n,bottoms[0]);
        return result;
    }
}