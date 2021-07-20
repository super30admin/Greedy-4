// Time complexity - O(n)
// space complexity - O(1)

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0 || B == null || B.length == 0) return 0;
        int r = check(A,B,A[0]);
        if(r != -1) return r;
        return check(A,B,B[0]);
    }
    
    private int check(int[] A, int[] B, int target){
        int aRot = 0; int bRot = 0;
        for(int i = 0 ; i < A.length; i++){
            if(A[i] != target &&  B[i] != target) return -1;
            else if(A[i] != target) aRot++;
            else if(B[i] != target) bRot++;
        }
        return Math.min(aRot,bRot);
    }
    
}
