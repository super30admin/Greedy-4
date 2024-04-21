// TC = O(n)
// SC = O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       int result = check(tops, bottoms, tops[1]);
       if(result != -1) return result;
       return check(tops, bottoms, bottoms[1]);
        
   
    }
    private int check(int[] tops, int[] bottoms, int target){
            int tRot = 0;
            int bRot = 0;
            for(int i = 0; i< bottoms.length; i++){
                if(tops[i] != target && bottoms[i] != target) return -1;
                if(tops[i] != target) tRot++;
                if(bottoms[i] != target) bRot++;

            }
            return Math.min(tRot,bRot);
    }
}