// Time Complexity : O(N)
// Space Complexity : O(1))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops, bottoms, tops[0]);
        if (result != -1)
            return result;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target) {
        int topR = 0;
        int botR = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target)
                return -1;
            if (target != tops[i]) {
                topR++;
            }
            if (bottoms[i] != target) {
                botR++;
            }
        }
        return Math.min(topR, botR);
    }
}