/* Time Complexity : O(n) 
 *  n - length of tops or bottoms */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//One pass

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        //Choose a pair from tops and bottoms and check if equal row is possible or not
        int result = check(tops, bottoms, tops[0]);
        if(result != -1) return result;
        return check(tops, bottoms, bottoms[0]);
    }

    private int check(int[] tops, int[] bottoms, int target){
        int aRot = 0;
        int bRot = 0;
        for(int i = 0; i < tops.length; i++){
			//either the top or bottom ele must be the target
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
			//If top ele is the target
            if(tops[i] != target){
                aRot++;
            }
			//If top ele is the target
            if(bottoms[i] != target){
                bRot++;
            }            
        }
        return Math.min(aRot, bRot);        
    }
}