// Approach: Constant space Greedy.
// Time: O(n)
// Space: O(1)

class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int re = compare(tops, bottoms, tops[0]);
        if (re != -1) return re;
        return compare(tops, bottoms, bottoms[0]);
    }

    private int compare(int[] tops, int[] bottoms, int target) {
        int aRot = 0, bRot = 0;
        for (int i = 0; i<tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) return -1;
            if (tops[i] != target) aRot++;
            if (bottoms[i] != target) bRot++;
        }
        return Math.min(aRot, bRot);
    }
}