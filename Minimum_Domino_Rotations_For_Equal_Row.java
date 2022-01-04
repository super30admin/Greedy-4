class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops == null || tops.length == 0) return 0;
        int result = check(tops, bottoms, tops[1]);
        
        if(result != -1) return result;
        return check(tops, bottoms, bottoms[1]); 
    }
    
    private int check(int[] tops, int[] bottoms, int target){
        int tRot = 0;
        int bRot = 0;
        
        for(int i= 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            else if(tops[i] != target) tRot++;
            else if(bottoms[i] != target) bRot++;
            
        }
        return Math.min(tRot, bRot);
    }
}

//TC: O(n)
//SC: O(1)
