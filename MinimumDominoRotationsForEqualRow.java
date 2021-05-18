// TC - O(n)

// SC - O(1)

// LC - 1007

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        
		// The first index value of A or B should be the answer, so we check both the values if they can be the answer
        int rot1 = getRot(A, B, A[0]);
        
        if(rot1 != -1 || A[0] == B[0]){
            return rot1;
        }
        
        return getRot(A, B, B[0]);        
    }
    
	// Function to get number of rotations
    private int getRot(int[] A, int[] B, int val){
        int aRot = 0;
        int bRot = 0;
        
        for(int i=0; i<A.length; i++){
            if(A[i] != val && B[i] != val){
                return -1;
            }else if(A[i] != val){
                aRot++;
            }else if(B[i] != val){
                bRot++;
            }
        }
        return Math.min(aRot, bRot);
    }
}