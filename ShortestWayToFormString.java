// Time Complexity: O(m*n), m is the length of the source string, n is the length of the target string
// Space Complexity: O(1)
// LeetCode 1055

class Solution {
	public int shortestWay(String source, String target) {
		int sCursor = 0, tCursor = 0;
		int count = 0;

		while(tCursor < target.length()) {
			while(sCursor < source.length()) {
				if(source.charAt(sCursor) == target.charAt(tCursor)) {
					sCursor++;
					tCursor++;
				} else {
					sCursor++;
				}
			}

			sCursor = 0;
			count++;
		}

		return count;
	}
}