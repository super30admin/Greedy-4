class Solution {
    int check(int[] tops, int []bottoms, int target) {
        int topcount=0;
        int bottomcount = 0;
        for(int i =0; i<tops.length;i++) {
            if(tops[i] != target && bottoms[i] != target ) {
                return -1;
            }
            if(bottoms[i] != target) {
               bottomcount++;
            } 
            if(tops[i] != target) {
                topcount++;
            }
        }
        return Math.min(topcount, bottomcount);
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops, bottoms, tops[0]);
        if(result != -1) {
            return result;
        }
        return check(tops,bottoms,bottoms[0]);
    }
}