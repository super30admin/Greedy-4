// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        int le = tops.length;

        for (int i = 0; i < tops.length; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            if (map.get(tops[i]) >= le) {
                target = tops[i];
                break;
            }
        }
        for (int i = 0; i < bottoms.length; i++) {
            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            if (map.get(bottoms[i]) >= le) {
                target = bottoms[i];
                break;
            }
        }
        int trot=0, brot=0;
        for(int i =0;i<le;i++)
        {
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target) trot++;
            if(bottoms[i] != target) brot++;

        }
        return Math.min(trot,brot);
    }
}