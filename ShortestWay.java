// TC O(MN) SC O(1) 
class Solution {
    public int shortestWay(String source, String target) {
        if (source == null || source.length() == 0) {
            return -1;
        }
        int i = 0, j = 0, count=0;
        while(j < target.length()) {
            count++;
            int curr = j;
            i = 0;
            while (i < source.length() && j < target.length()) {
                char s = source.charAt(i);
                char t = target.charAt(j);
                if (s == t) {
                    j++;
                }
                i++;
            }
            if (curr == j){
                return -1;
            }
        }
        return count;
    }
}
