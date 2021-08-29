package Greedy4;

public class MinimumDominoRotation1 {
	//TC : o(n)
	//SC : o(n)
	//Approach : Create a hashmap to know which element to swap(that is  >=6). find no. of rotations for tops and bottoms which ever is freq element and take minimum
	class Solution {
	    public int minDominoRotations(int[] tops, int[] bottoms) {
	        //null case
	        if(tops == null || tops.length == 0) return 0;
	        
	        HashMap<Integer, Integer> map = new HashMap<>();
	        int res = -1;
	        
	        for(int i=0; i<tops.length; i++){
	            int top = tops[i];
	            map.put(top, map.getOrDefault(top,0)+1);
	            if(map.get(top) >= tops.length){
	                res = top;
	            }
	            int bottom = bottoms[i];
	            map.put(bottom, map.getOrDefault(bottom,0)+1);
	            if(map.get(bottom) >= bottoms.length){
	                res = bottom;
	            }
	        }
	        
	        if(res == -1) return -1;
	        int topsRot = 0;
	        int bottomsRot = 0;
	        for(int i=0; i<tops.length; i++){
	            if(tops[i]!=res && bottoms[i]!=res) return -1;
	            if(tops[i]!=res) topsRot++;
	            if(bottoms[i]!=res) bottomsRot++;
	        }
	        
	        return Math.min(topsRot, bottomsRot);
	    }
	}
}
