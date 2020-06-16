// Time Complexity :O(mn) where m is the length of source and n is the length of the target.
// Space Complexity :O(1);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {

        int i = 0; int j = target.length();
        int count = 0;
        while(i<j)
        {
            int curr = i;
            for(int k =0;k <source.length() && i < j;k++)
            {
                if(source.charAt(k)==target.charAt(i)) i++;
            }
            if(curr == i) return -1;
            count++;
        }
        return  count;
    }
}