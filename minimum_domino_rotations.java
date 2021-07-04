/*

https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
Did it run on leetcode: Yes

Time Complexity: 0(N)
Space Complexity: 0(1)

Algorithm:
- since (A[i],B[i]) will form the pairs
- first we take A[0] as our value for which we will make around rotations
- if we get -1 then we take B[0] as our value for which we will make rotations


*/

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
        // check for A[0]
        int ans = -1;
        ans = checkMinimumDominoRotations(A,B,A[0]);
        if(ans!=-1){
            return ans;
        }
        
        // check for B[0]
        ans = checkMinimumDominoRotations(A,B,B[0]);
        if(ans!=-1){
            return ans;
        }
        
        return -1;
    }
    
    public int checkMinimumDominoRotations(int[] A, int[] B,int x){
        
        int a_rot=0,b_rot=0;    
        for(int i=0;i<A.length;++i){
            
            if(A[i]!=x && B[i]!=x){
                return -1;
            }
            else if(A[i]!=x){
                a_rot++;
            }
            else if(B[i]!=x){
                b_rot++;
            }
        }
        
        return Math.min(a_rot,b_rot);
        
    }
}