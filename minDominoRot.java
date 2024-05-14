
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Tc: O(n) Sc: O(1)
        if (tops == null || tops.length == 0)
            return 0;
        int res = check(tops, bottoms, tops[0]);
        if (res != -1)
            return res;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int cand) {
        int n = tops.length;
        int topRot = 0;
        int botRot = 0;
        for (int i = 0; i < n; i++) {
            if (tops[i] != cand && bottoms[i] != cand)
                return -1;
            if (tops[i] != cand)
                topRot++;
            if (bottoms[i] != cand)
                botRot++;
        }

        return Math.min(topRot, botRot);
    }
}

/*
 * class Solution {
 * public int minDominoRotations(int[] tops, int[] bottoms) {
 * //Tc: O(n) Sc: O(1)
 * HashMap<Integer, Integer> countMap = new HashMap<>();
 * for (int i = 0; i < tops.length; i++) {
 * countMap.put(tops[i], countMap.getOrDefault(tops[i], 0) + 1);
 * countMap.put(bottoms[i], countMap.getOrDefault(bottoms[i], 0) + 1);
 * }
 * 
 * Integer target = null;
 * for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
 * if (entry.getValue() >= tops.length) {
 * target = entry.getKey();
 * break;
 * }
 * }
 * 
 * if (target == null) {
 * return -1;
 * }
 * 
 * int topRotations = 0;
 * int bottomRotations = 0;
 * for (int i = 0; i < tops.length; i++) {
 * if (tops[i] != target && bottoms[i] != target) {
 * 
 * return -1;
 * } else if (tops[i] != target) {
 * 
 * topRotations++;
 * } else if (bottoms[i] != target) {
 * 
 * bottomRotations++;
 * }
 * }
 * 
 * return Math.min(topRotations, bottomRotations);
 * }
 * 
 * }
 */