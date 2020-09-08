/*
Approach:
Take A[0] as target and compare and get the no of swaps possible if we dont get any result then check with B[0] and return the min no of domino rotations
*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int result = check(A,B,A[0]);
        if(result != -1) return result;
        return check(A,B,B[0]);        
    }
   
    private int check(int[]A,int[]B,int target){
        int aRot = 0 ; int bRot = 0;
        for(int i = 0; i <A.length ;i++){
            if(A[i] != target && B[i]!= target) return -1;
            else if(A[i] != target) aRot++;  // O(n)
            else if(B[i] != target) bRot++;  //O(n)
        }
        return Math.min(aRot,bRot);
    }
}

/*
Time complexity : Iterating over using A[0] on both the arrays O(n) +O(n) = O(2n)
Space complexity : O(1)
*/
