// Time Complexity : O(m*n) m -> length of source string, n-> length of target string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//Approach: 
// Iterating over target string and tracking the current character index in comparison with previous one w.r.t. the source string.
// If current index position is greater that means that the character is part of same subsequence, otherwise count is incremented and previous index is reset.

class Solution {
    public int shortestWay(String source, String target) {
        // edge case
        if(source == null || target == null)
            return 0;
        
        int count = 1, prevCharIdx = -1;
        for(int i = 0; i < target.length(); i++) {
            char curr = target.charAt(i);
            int currCharIdx = source.indexOf(curr, prevCharIdx+1);
            if(currCharIdx > prevCharIdx) {
                prevCharIdx = currCharIdx;
                continue;
            }
            else {
                count++;
                prevCharIdx = source.indexOf(curr);
                if(prevCharIdx < 0)
                    return -1;
            }
        }
        return count;
    }
}
