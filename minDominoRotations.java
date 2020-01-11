//TC: O(n)
//SC: O(1)
//Approach: We try to check for a specific number from the commom pair in the first index of A and B, if checking in A return -1, that's when we would check ofr no. of rotations for the second number.

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(checker(A,B,A[0])==-1)
            return checker(A,B,B[0]);
        else 
            return checker(A,B,A[0]);
    }
    private int checker(int[] A, int[] B, int X){
        int rotA=0,rotB=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=X&&B[i]!=X)
                return -1;
            else if(A[i]!=X)
                rotA++;
            else if(B[i]!=X)
                rotB++;
        }
        return Math.min(rotA,rotB);
    }
}
