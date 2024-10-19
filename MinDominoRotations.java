// Problem 1007. Minimum Domino Rotations For Equal Row
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int re = check(tops, bottoms, tops[0]);
        if (re != -1) return re;
        return check(tops, bottoms, bottoms[0]);
    }
    private int check(int[] tops, int[] bottoms, int target) {
        int tRot = 0; 
        int bRot = 0;
        for (int i = 0; i < tops.length; i++) {
            int tp = tops[i];
            int bp = bottoms[i];
            if (tp != target && bp != target) return -1;
            if (tp != target) tRot++;
            if (bp != target) bRot++;
        }
        return Math.min(tRot, bRot);
    }
}
