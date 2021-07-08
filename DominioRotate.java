// Time Complexity : O(2n)= O(n) where n is the number of elements in the array A
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : none
/* Your code here along with comments explaining your approach:In approach 1, we know that there are 6 numbers at most. We will find the max frequency
element and keep a track of it. As we get the max frequency, we would find whether Array A and B has the number  if they bothe have it at same index,
we dont care , if not, then increment a_rotation and b_rotation whereeever character is not present. In approach 2, we dont need to get the max frequency,
we can take any pair at random and see if the element at A(i) is available at all the other indices of either A and B, else we can also check the same
for B(i) on all the other indices. Either should return the result.
*/
// APPROACH 1 :
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0) return 0;
        int maxFreq =0, max = -1, aRot = 0, bRot = 0, number = 0;
        for(int j = 0; j < 7; j++){
            maxFreq = 0;
            for(int i  =0; i < A.length; i++){
                    if(A[i] == j) maxFreq++;                                                                        // Check numbers from 1-6
                    if(B[i] == j) maxFreq++;
            }
              if(maxFreq >= max){                                                                               // Get the number with max frequency
                  max = maxFreq;
                  number = j;
                } 
        }
       for(int i  = 0; i < A.length; i++){
        if(A[i] != number && B[i] != number) return -1;                                                     // If numbers at an index are not equal we are done
        if(A[i] == number && B[i] == number) continue;                  
                if(A[i] == number) bRot++;                                                                  // If the number is not present in B, rotate B  
                if(B[i] == number) aRot++;                                                                  // If the number is not present in A, rotate A
            }
        return Math.min(aRot, bRot);
    }
}

// APPROACH 2:
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        if(A == null || A.length == 0) return 0;
        int result = check(A, B, A[0]);                                                             // Take a random pair , check with A(i)
        if(result != -1) return result;
        else return check(A, B, B[0]);                                                                  // Check with B(i), either shall work
    }
    private int check(int[] A, int[] B, int number){
        int aRot = 0, bRot = 0;
       for(int i  = 0; i < A.length; i++){
        if(A[i] != number && B[i] != number) return -1;                                                 // If the numbers are not equal at that index
        if(A[i] == number && B[i] == number) continue;
                if(A[i] == number) bRot++;                                                                  // If the number is not present in B, Rotate B
                if(B[i] == number) aRot++;                                                              // if the number is not present in A, Rotate A
        }
        return Math.min(aRot, bRot);                                                                            // Return min number of rotations
    }
}

