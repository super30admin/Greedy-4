// Problem 1055. Shortest Way to Form String
// Time Complexity : O(tLen * sLen)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int shortestWay(String source, String target) {
        int sLen = source.length();
        int tLen = target.length();
        int tIndex = 0;
        int count = 0;
        while (tIndex < tLen) {
            int sIndex = 0;
            boolean matched = false;
            while (sIndex < sLen && tIndex < tLen) {
                if (source.charAt(sIndex) == target.charAt(tIndex)) {
                    tIndex++;
                    matched = true;
                }
                sIndex++;
            }
            if (!matched) return -1;
            count++;
        }
        return count;
    }
}