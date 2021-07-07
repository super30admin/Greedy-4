//TC: O(n)
//SC: O(1)

//84 / 84 test cases passed. Status: Accepted Runtime: 4 ms Memory Usage: 41.6 MB

//Approach : We will take the first element of array A and check whether each element at a particular index of A and B equals this element.
//If both donot equals this element, return -1.If only one is not the same then increase the number of rotation by one for that array.
//Once array are traversed once, return the minimum rotations number. Do the same with first element of array B.

class Solution {
    
    public int check(int[] A, int[] B, int x){
        
        int a_rotations = 0;
        int b_rotations = 0;
        
        for(int i=0; i<A.length; i++){
            if(A[i]!= x && B[i]!= x) return -1;
            else if (A[i]!= x) a_rotations++;
            else if (B[i]!=x) b_rotations++;
        }
        
        return Math.min(a_rotations, b_rotations);
    }
    public int minDominoRotations(int[] A, int[] B) {
        
        int retVal  = check(A, B, A[0]) ;
        
        if(retVal !=-1 || A[0] == B[0]) return retVal;
        
        return check(A, B , B[0]);
        
    }
}
