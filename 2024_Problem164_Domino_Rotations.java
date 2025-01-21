//1007. Minimum Domino Rotations For Equal Row - https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/description/
//Time Complexity: O(2n) ~ O(n)
//Space Complexity: O(1) ~ Domino has 6 sides so map will have 6 entries at max

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        for(int i=0; i<n; i++){
            //for top
            map.put(tops[i], map.getOrDefault(tops[i], 0)+1);
            if(map.get(tops[i]) == n){
                target = tops[i];
                break;
            }
            //for bottom
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0)+1);
            if(map.get(bottoms[i]) == n){
                target = bottoms[i];
                break;
            }
        }

        int topR=0, botR=0;

        for(int i=0; i<n; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) topR++; //top rotation
            if(bottoms[i] != target) botR++; //bottom rotation

        }

        return Math.min(topR, botR);
    }
}