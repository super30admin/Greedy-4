//TC - O(N)
//SC - O(1)
class Solution {
	public int minDominoRotations(int[] A, int[] B) {
		// edge
		if (A == null || A.length == 0)
			return 0;
		int maxFreq = 0;
		for (int i = 1; i < 7; i++) {
			int count = 0;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == i)
					count++;
				if (B[j] == i)
					count++;
				if (count >= A.length) {
					maxFreq = i;
					break;
				}
			}
		}
		int aRot = 0;
		int bRot = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != maxFreq && B[i] != maxFreq)
				return -1;
			else if (A[i] != maxFreq)
				bRot++;
			else if (B[i] != maxFreq)
				aRot++;
		}
		return Math.min(aRot, bRot);
	}
}