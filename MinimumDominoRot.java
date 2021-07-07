//Time Complexity: O(N)
//Space Complexity: O(1)
//Take the first domino tile and hence take A[0] and B[0]
//Check if the top part or A array can be made equal by comparing with all elements in A and B array
//Do same for B[0] to chek if it can be made same.
//Calculate the number of rotations in both cases and return its minimum
class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int n = A.length;
        int rot = check(A[0], A, B, n);
        if(rot!=-1 || A[0] == B[0])
            return rot;
        else
            return check(B[0], B, A, n);
    }
    
    public int check(int x, int[] A, int [] B, int n)
    {
        int rot_A = 0, rot_B = 0;
        for(int i =0; i < n; i++)
        {
            if(A[i]!=x && B[i]!= x) return -1;
            else if(A[i]!=x) rot_A++;
            else if(B[i]!=x) rot_B++;
        }
        return Math.min(rot_A, rot_B);
    }
}