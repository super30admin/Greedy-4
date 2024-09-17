//TC - O(N)
//SC - O(1)
class Solution1 {
	public int minDominoRotations(int[] A, int[] B) {
		// edge
		if (A == null || A.length == 0)
			return 0;
		int result = check(A, B, B[0]);
		if (result != -1)
			return result;
		return check(A, B, A[0]);
	}

	public int check(int[] A, int[] B, int target) {
		int aRot = 0;
		int bRot = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != target && B[i] != target)
				return -1;
			else if (A[i] != target)
				bRot++;
			else if (B[i] != target)
				aRot++;
		}
		return Math.min(aRot, bRot);
	}
}