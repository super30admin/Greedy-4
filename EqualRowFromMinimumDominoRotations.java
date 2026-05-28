// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Maintain a hashmap to identify and count how many times each candidate appears and find the common one.Now,
lets say if a candidate appears in both tops and bottoms, then its a possible target. Now we go through
the both arrays and count minimum number of swaps needed to match that target if not present in either of
the arrays.
 */
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer, Integer> map = new HashMap<>();
        int le = tops.length;
        int target = -1;

        for(int i = 0 ; i < tops.length ; i++) {
            map.put(tops[i], map.getOrDefault(tops[i], 0) + 1);
            if(map.get(tops[i]) == le) {
                target = tops[i];
                break;
            }

            map.put(bottoms[i], map.getOrDefault(bottoms[i], 0) + 1);
            if(map.get(bottoms[i]) == le) {
                target = bottoms[i];
                break;
            }
        }

        if(target == -1)
            return -1;

        return helper(map, tops, bottoms, target);
    }

    private int helper(Map<Integer, Integer> map, int[] tops, int[] bottoms, int target) {
        int topsR = 0 , bottomsR = 0;
        for(int i = 0 ; i < tops.length ; i++) {
            if(tops[i] != target && bottoms[i] != target)
                return -1;
            else if(tops[i] == target && bottoms[i] == target)
                continue;
            else if(tops[i] != target && bottoms[i] == target)
                topsR++;
            else if(tops[i] == target && bottoms[i] != target)
                bottomsR++;
        }
        return Math.min(topsR, bottomsR);
    }
}