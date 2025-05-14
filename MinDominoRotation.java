/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Check all rotations possible by selecting first number from tops
 * 2. Check all rotations possible by selecting first number from bottoms, if not found from top
 */

public class MinDominoRotation {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = findMinRotations(tops, bottoms, tops[0]);
        if (res != -1) {
            return res;
        }
        return findMinRotations(tops, bottoms, bottoms[0]);
    }


    private int findMinRotations(int[] tops, int[] bottoms, int target) {
        int topRot = 0;
        int bottomRot = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

            if (tops[i] != target) {
                topRot++;
            }

            if (bottoms[i] != target) {
                bottomRot++;
            }
        }

        return Math.min(topRot, bottomRot);
    }
    public static void main(String[] args) {
        // Your code here
    }
}