// Time Complexity: O(N)
// Space Complexity: O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int aCount = rotationsCount(tops, bottoms, tops[0]);
        if (aCount == -1)
            return rotationsCount(tops, bottoms, bottoms[0]);
        return aCount;
    }

    private int rotationsCount(int[] tops, int[] bottoms, int chosen) {
        int aCount = 0;
        int bCount = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != chosen && bottoms[i] != chosen)
                return -1;
            if (tops[i] != chosen)
                aCount++;
            if (bottoms[i] != chosen)
                bCount++;
        }

        return Math.min(aCount, bCount);
    }
}