// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int cntA = check(tops,bottoms,tops[0]);
        if(cntA != -1)
           return cntA;
        return check(tops,bottoms,bottoms[0]);
    }
    private int check(int[] tops, int[] bottoms, int target){
        int arot = 0;
        int brot = 0;
        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target)
                return -1;
            if(tops[i] != target)
                arot++;
            if(bottoms[i] != target)
                brot++;
        }
        return Math.min(arot,brot);
    }
}