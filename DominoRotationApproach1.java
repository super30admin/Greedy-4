/*
Approach
Find the filter by going through the entire array and store in maxFreq
Swap over the filter for A aRotation ,for B bRotation . Minimum number of swaps required  is no of minimum domino rotations required

A.length and B.length will be same because we need to swap between the tiles
*/
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
       
        if(A == null || A.length == 0  ) return 0;
        int count = 0; int maxFreq = 0;
        for(int i = 1 ; i < 7 ;i++){       // O(7)
            count = 0;                    // reset if maxFreq not found
            for(int j = 0 ; j < A.length ;j++){ // O(length of A)
                if(A[j] == i ) count++;
                if(B[j] == i ) count++;
               
                if(count >= A.length) {
                    maxFreq = i;
                    break;
                }
            }
        }
        int aRot = 0 ; int bRot = 0;
        for(int i = 0 ; i < A.length ; i++){  // O(n)
            if(A[i]!= maxFreq && B[i]!= maxFreq) return -1;
           
        //at one time any of the two conditions will happen
            else if(A[i] != maxFreq) aRot++;
            else if(B[i] != maxFreq) bRot++;
        }
       
        return Math.min(aRot,bRot);
    }
}
   
/*
Time complexity :

Going over the array twice once for finding filter is O(7*length of A)and
another for counting no of swaps ie O(n*7*7) aymtotically O(n*49 ) ie O(n)
Space complexity: O(1)
Note: since A[i] lies between 1 and 6 total length of A is 7

*/