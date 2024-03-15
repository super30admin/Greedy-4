/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(2n)
    n = length of tops or bottoms
* 
* Space Complexity: O(1)
* 
*/

public class MinDominosRotation {
    private int dominoRotations(int[] tops, int[] bottoms, int target) {
        int topCount = 0;

        int bottomCount = 0;

        for (int index = 0; index < tops.length; index++) {
            if (tops[index] != target && bottoms[index] != target) {
                return -1;
            }

            if (tops[index] != target) {
                topCount++;
            }

            if (bottoms[index] != target) {
                bottomCount++;
            }
        }

        return Math.min(topCount, bottomCount);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotation1 = dominoRotations(tops, bottoms, tops[0]);

        if (rotation1 != -1) {
            return rotation1;
        }

        return dominoRotations(tops, bottoms, bottoms[0]);
    }
}