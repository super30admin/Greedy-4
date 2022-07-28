//Time Complexity: O(n)
//Space Complexity: O(1)
class Solution {
     int n;
    public int minDominoRotations(int[] tops, int[] bottoms) {
        
        n = tops.length;
        int result = count(tops,bottoms,tops[0]);
        if(result!=-1){
            return result;
        }
        return count(tops,bottoms,bottoms[0]);
    }
    
    private int count(int[] tops, int[] bottoms, int target){
        int trot = 0;
        int brot = 0;
        for(int i=0; i<n; i++){
            int t = tops[i];
            int b = bottoms[i];
            
            if (t!= target && b!= target){
                return -1;
            }
            
            if (t!= target){
                trot++;
            }
            
            if (b!= target){
                brot++;
            }
        }
        return Math.min(trot,brot);
        
    }
        
    
}