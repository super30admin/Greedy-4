//TC - O(M x N)
//SC - O(1)
class Solution2 {
	public int shortestWay(String source, String target) {
		int s = source.length();
		int t = target.length();
		int TP = 0;
		int SP = 0;
		int count = 0;
		while (TP < t) {
			int curr = TP;
			SP = 0;
			count++;
			while (TP < t && SP < s) {
				if (source.charAt(SP) == target.charAt(TP)) {
					TP++;
				}
				SP++;
			}
			if (curr == TP)
				return -1;
		}
		return count;
	}
}