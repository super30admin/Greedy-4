package Greedy4;

public class MinimumDominoRotation2 {
	//TC : o(n)
	//SC : o(n)
	//Approach: still a 2 pass algorithm but better efficient
	class Solution {
	    public int minDominoRotations(int[] tops, int[] bottoms) {
	        //null case
	        if(tops == null || tops.length == 0) return 0;
	        int result = check(tops,bottoms,tops[0]);
	        if(result != -1)return result;
	        return check(tops,bottoms,bottoms[0]);
	        
	    }
	    
	    private int check(int[] tops, int[] bottoms, int target){
	        int aRot = 0;
	        int bRot = 0;
	        for(int i=0; i<tops.length; i++){
	            if(tops[i]!=target && bottoms[i]!=target) return -1;
	            if(tops[i]!=target) aRot++;
	            if(bottoms[i]!=target) bRot++;
	        }
	        return Math.min(aRot, bRot);
	    }
	}
}
