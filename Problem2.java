// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
//Using Greedy approach and choosing the first element of either tops or bottoms array as target which is required for all the values to be same
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = check(tops, bottoms, tops[0]);
        if(res != -1) return res;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int aRot=0;
        int bRot = 0;
        for(int i = 0; i < tops.length;i++) {
            if(tops[i] != target && bottoms[i] != target) return -1;

            if(tops[i] != target) aRot++;

            if(bottoms[i] != target) bRot++;
        }
       return Math.min(aRot, bRot);
    }
}
