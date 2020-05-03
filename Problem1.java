class Solution {
    public int shortestWay(String source, String target) {

        if (source == null || target == null) {
            return -1;
        }

        int s = 0;
        int t = 0;
        int count = 0;

        while (t < target.length()) {
            int current = t;
            while (s < source.length() && t < target.length()) {
                if (source.charAt(s) == target.charAt(t)) {
                    s++;
                    t++;
                } else {
                    s++;
                }
            }

            if (t == current) {
                return -1;
            }
            s = 0;
            count++;
        }

        return count;
    }
}