//Approach - 1: 2 Pass, HashMap
//Time Complexity : O(n)
//Space Complexity : O(1) // Just dice has just 6 sides
 
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int n = tops.length;
        //Element which you have to replcae
        int candidate = -1;
        
        //1st Pass
        for(int i=0; i<n; i++){
            
            int top = tops[i];
            map.put(top, map.getOrDefault(top,0) + 1);
            int countTop = map.get(top);
        
            if(countTop >= n){
                //We found candidate element for replacing
                candidate = top;
                break;
            }
            
            int bottom = bottoms[i];
            map.put(bottom, map.getOrDefault(bottom,0) + 1);
            int countBottom = map.get(bottom);
        
            if(countBottom >= n){
                //We found candidate element for replacing
                candidate = bottom;
                break;
            }
        }
        if(candidate == -1) return -1;
        
        
        //2nd Pass
        int topRotation = 0;
        int bottomRotation = 0;
        for(int i=0; i<n; i++){
            if(candidate != tops[i] && candidate != bottoms[i]) return -1;
            if(tops[i] != candidate) topRotation ++;
            if(bottoms[i] != candidate) bottomRotation ++;
        }
        return Math.min(topRotation, bottomRotation);
    }
}



//Approach - 1: 2 Pass
//Time Complexity : O(n)
//Space Complexity : O(1) 
 
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        int n = tops.length;
        //Element which you have to replcae
        int candidate = -1;
        int result = check(tops, bottoms, tops[0]);
        if(result != -1) return result;
        return check(tops, bottoms, bottoms[0]);
    
        
    }
    
    private int check(int[] tops, int[] bottoms, int candidate){
        int topRotation = 0;
        int bottomRotation = 0;
        for(int i=0; i<tops.length; i++){
            if(candidate != tops[i] && candidate != bottoms[i]) return -1;
            if(tops[i] != candidate) topRotation ++;
            if(bottoms[i] != candidate) bottomRotation ++;
        }
        return Math.min(topRotation, bottomRotation);
    }
}
