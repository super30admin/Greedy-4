// Time Complexity : O(m * n) --> where m and n are the lengths of source and target input string
// Space Complexity :
// Did this code successfully run on Leetcode (1055): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        int s = source.length(); int t = target.length();
        int SP = 0; // source pointer
        int TP = 0; // targer pointer
        int count = 0;
        
        while (TP < t) {
            SP = 0;
            int curr = TP;
            while (SP < s && TP < t) {
                if (source.charAt(SP) == target.charAt(TP)) TP++;
                SP++;
            }
            count++;
            if (curr == TP) return -1;
        }
        
        return count;
    }
}