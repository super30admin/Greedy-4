Time Complexity = O(n)
Space Complexity = O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int rotations = flip(A,B,A[0]);
        if(rotations != -1)return rotations;//rotation fails i.e value doesnt match to x
        return flip(A,B,B[0]);
    }
    
    public int flip(int[] a,int[] b,int target){
        int top = 0,bottom = 0;
        
        for(int i = 0; i < a.length;i++){
            if(a[i] != target && b[i] != target){
                return -1;
            }else if(a[i] != target){
                top++;
            }else if(b[i] != target){
                bottom++;
            }
        }
        return Math.min(top, bottom);
    }
}