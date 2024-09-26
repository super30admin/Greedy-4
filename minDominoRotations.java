//Time: O(n)
//Space: O(1)
//LeetCode: Yes
//No issues

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        //validation
        if(A==null || A.length==0 || B==null || B.length==0 || A.length!=B.length){
            return -1; //Invalid
        }
        int n=A.length;
        int rot=check(n, A, B, A[0]);
        if(rot!=-1) return rot;
        return check(n, A, B, B[0]);
    }
    
    private int check(int n, int[] A, int[] B, int x){
        int aRot=0, bRot=0;
        for(int i=0; i<n; i++){
            if(A[i]!=x && B[i]!=x){
                return -1; //Invalid
            } else if(A[i]!=x){
                aRot++;
            } else if(B[i]!=x){
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}
