//Time complexity is O(n)
//Space complexity is o(1)
//This solution is submitted on leetcode

public class BigN161MinimumDominoRotations {
	class Solution {
		public int minDominoRotations(int[] A, int[] B) {
			int rot = checker(A, B, A[0]);
			if (rot != -1)
				return rot;
			return checker(A, B, B[0]);
		}

		private int checker(int[] A, int[] B, int x) {
			int aRot = 0;
			int bRot = 0;
			for (int i = 0; i < A.length; i++) {
				if (A[i] != x && B[i] != x)
					return -1;
				else if (A[i] != x)
					aRot++;
				else if (B[i] != x)
					bRot++;
			}
			return Math.min(aRot, bRot);
		}
	}
}