// Time Complexity: O(n), where n is the length of the domino array
// Space Complexity: O(1)
// LeetCode 1007

class Solution {
    public int minDominoRotations(int[] A, int[] B) {

    	int rotations = check(A, B, A[0]);
    	if(rotations != -1) return rotations;
    	return check(A, B, B[0]);
        
    }

    private int check(int[] A, int[] B, int x) {
    	int top = 0, bottom = 0;

    	for(int i = 0; i < A.length; i++) {
    		if(A[i] != x && B[1] != x) return -1;
    		else if(A[i] != x) top++;
    		else if(B[i] != x) bottom++;
    	}

    	return Math.min(top, bottom);
    }
}