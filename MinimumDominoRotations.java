//time-O(n), space - O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops==null || bottoms==null || tops.length==0 || bottoms.length==0) return 0;
        int res = calculate(tops, bottoms, tops[0]);
        if(res==-1){
            res = calculate(tops, bottoms, bottoms[0]);
        }
        return res;
    }
    private int calculate(int[] tops, int[] bottoms, int target){
        int topRotations = 0, bottomRotations = 0;

        for(int i=0; i<tops.length; i++){
            if(tops[i]!=target && bottoms[i]!=target){
                return -1;
            }
            else if(tops[i]!=target){
                topRotations++;
            }
            else if(bottoms[i]!=target){
                bottomRotations++;
            }
        }

        return Math.min(topRotations, bottomRotations);
    }
}
