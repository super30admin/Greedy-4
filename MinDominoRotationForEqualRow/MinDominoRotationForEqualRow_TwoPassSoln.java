/* Time Complexity : O(n) 
 *  n - length of tops or bottoms */
/* Space Complexity : O(1) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//Two pass

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;//the number with which equal row would be formed(if possible) 
		
		//Iterate over tops and bottoms array and preparing a frequesncy map , along with identifying the target
        for(int i = 0; i < n; i++){
            int tp = tops[i];
            map.put(tp, map.getOrDefault(tp, 0) + 1);
			//The no. of occurences should be greater than or equal to the length of tops array for that number to be a target
            if(map.get(tp) >= n){
                target = tp;
                break;
            }

            int bp = bottoms[i];
            map.put(bp, map.getOrDefault(bp, 0) + 1);
			//The no. of occurences should be greater than or equal to the length of tops array for that number to be a target
            if(map.get(bp) >= n){
                target = bp;
                break;
            }
        }

        if(target == -1) return -1;
        int aRot = 0;
        int bRot = 0;
        for(int i = 0; i < n; i++){
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