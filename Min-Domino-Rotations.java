// Time Complexity : O(2N) 

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: HashMap - Store the frequency of the both elements in map. Find the target element. 
// check which element is not equal to target and increment count.

// 1055. Shortest Way to Form String

import java.util.HashMap;

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length; 
        int target = 0; 
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<tops.length;i++){
            map.put(tops[i],map.getOrDefault(tops[i],0) + 1);
            if(map.get(tops[i]) >= n){
                target = tops[i];
                break;
            }
        }
        for(int i=0;i<bottoms.length;i++){
            map.put(bottoms[i],map.getOrDefault(bottoms[i],0) + 1);
            if(map.get(bottoms[i]) >= n){
                target = bottoms[i];
                break;
            }
        }
        int topR = 0;
        int botR = 0;
        for(int i = 0;i<n;i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] != target){
                topR++;
            }
            if(bottoms[i] != target){
                botR++;
            }
        }
        return Math.min(topR,botR);
    }
}