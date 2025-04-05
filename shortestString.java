// Time Complexity : O(N*mlogm)
// Space Complexity : O(m))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int shortestWay(String source, String target) {
        int cnt = 1;
        int m = source.length();
        int n = target.length();
        int j = 0;

        HashMap<Character, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char c = source.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int i = 0;

        while (j < n) {
            char tc = target.charAt(j);
            if (!map.containsKey(tc))
                return -1;

            List<Integer> li = map.get(tc);
            int k = Collections.binarySearch(li, i);
            if (k < 0) {
                k = -k - 1;
            }
            if (k == li.size()) {
                i = 0;
                cnt++;
            } else {
                i = li.get(k);
                i++;
                j++;
            }
        }

        return cnt;
    }
}