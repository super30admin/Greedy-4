/* 
    LC - 1007. Minimum Domino Rotations For Equal Row
    TC - O(n)
    SC - O(1)
*/

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || bottoms == null || tops.length == 0 || bottoms.length == 0) {
            return -1;
        }
        int target = findMinRotations(tops, bottoms, tops[0]);
        if(target != -1) {
            return target;
        }
        return findMinRotations(tops, bottoms, bottoms[0]);
    }
    private int findMinRotations(int[] tops, int[] bottoms, int target) {
        int topRotations = 0;
        int bottomRotations = 0;
        for(int i=0; i<tops.length; i++) {
            if(tops[i] != target && bottoms[i]!= target) {
                return -1;
            }
            if(tops[i] != target) {
                topRotations++;
            }
            if(bottoms[i]!= target) {
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations);
    }
}