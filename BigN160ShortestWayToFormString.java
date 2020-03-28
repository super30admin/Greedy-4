// Time complexity is O(n*m)
// Space complexity is o(1)
// Not submitted on leetcode

public class BigN160ShortestWayToFormString {
	
	public static void main(String [] args) {
		String source = "xyz";
		String target = "xzyxz";
		System.out.println(shortestWay(source, target));
	}

	public static int shortestWay(String source, String target) {
		int S = source.length();
		int T = target.length();
		int SP = 0;
		int TP = 0;
		int curr = 0;
		int result = 0;
		while (TP < T) {
			SP = 0;
			curr = TP;
			while (SP < S && TP < T) {
				if (source.charAt(SP) == target.charAt(TP)) {
					SP++;
					TP++;
				} else
					SP++;
			}
			result++;
			if (curr == TP)
				return -1;
		}
		return result;
	}
}