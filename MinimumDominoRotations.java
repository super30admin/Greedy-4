/*
 * #1007. Minimum Domino Rotations For Equal Row
 * 
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the ith domino.  (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that A[i] and B[i] swap values.

Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.

If it cannot be done, return -1.

 

Example 1:
Refer image from leetcode

Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by A and B: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:

Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.
 

Constraints:

1. 2 <= A.length == B.length <= 2 * 104
2. 1 <= A[i], B[i] <= 6

 * 
 */


/*
 * Time Complexity: O (N) -> To traverse 'N' elements in A and B
 * 
 * Space Complexity: O (1) -> No extra space used'
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.greedy4;

public class MinimumDominoRotations {
	public int minDominoRotations(int[] A, int[] B) {
        
        // Get the minimum number of rotations for A[0]
        int min_rotation = get_rotations(A, B, A[0]);
        
        /* Case 1: If we get min_rotations from A[0], return the answer, do not get min_rotations for B[0]
        *  Case 2: If we get -1 from A[0] and A[0] != B[0], then get min_rotations for B[0]
        *  Case 3: If we get -1 from A[0] and A[0] = B[0], then return -1 as we will get -1 from B[0] as well since both A[0] and B[0] are equal
        *   
        */
        if(min_rotation != -1 || A[0] == B[0]){
            return min_rotation;
        }
        
        return get_rotations(A, B, B[0]);
        
    }
    
    public int get_rotations(int[] A, int[] B, int value){
       // Initialize the minimum number of rotations for both A and B
       int a_rotation = 0;
       int b_rotation = 0;
       
       // Traverse through each pair in A and B, Since length of A and B are same, we just check for A's length
       for(int i = 0; i < A.length; i++){
           
           // If the value (A[0] or B[0]) is not present in any of A[i] or B[i], means we cannot get all same values in either A or B after rotations, return -1 in that case
           if(A[i] != value && B[i] != value){
               return -1;
           }
           // Else if the value (A[0] or B[0]) is not present in A[i], means present in B[i], increment A's rotation count
           else if(A[i] != value){
               a_rotation += 1;
           }
           // Else if the value (A[0] or B[0]) is not present in B[i], means present in A[i], increment B's rotation count
           // We are not using Else here because, for case when A[i] = value and B[i] = value, we do not want to increment rotations for either A or B
           // If we had used Else, then it would have incremented B's rotation count even if B[i] = value
           /* e.g: A = 2 1 2 4 2 2
           *       B = 5 2 6 2 3 2
           *  Last element in A and B is equal, in that case do not increment any of the rotation count
           */
           else if(B[i] != value){
               b_rotation += 1;
           }
           
       }
        
      // return minimum rotations from A_rotation and B_rotation
      return Math.min(a_rotation, b_rotation);
        
    }
    
}
