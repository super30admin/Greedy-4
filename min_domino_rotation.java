// Time Complexity : O(n) because we scan the domino arrays at most twice
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// The final same value must be either tops[0] or bottoms[0], so we only need to test these two candidates.
// For each candidate, we check if every domino can support that value on either top or bottom.
// We count rotations needed to make all tops equal or all bottoms equal and return the minimum.

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int re = helper(tops, bottoms, tops[0]);
        if(re != -1) return re;

        return helper(tops, bottoms, bottoms[0]);
    }

    private int helper(int[] tops, int[] bottoms, int target) {
        int topR = 0, bottomR = 0;

        for(int i = 0; i < tops.length; i++) {

            // target not possible
            if(tops[i] != target && bottoms[i] != target) return -1;

            if(tops[i] == target && bottoms[i] == target) continue;

            if(tops[i] != target) topR++;
            if(bottoms[i] != target) bottomR++;
        }

        return Math.min(topR, bottomR);
    }
}