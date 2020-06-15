// Time Complexity :O(mn) where m is the length of source and n is the length of the target.
// Space Complexity :O(m);
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class Solution {
    public int shortestWay(String source, String target) {
        HashSet<Character> set = new HashSet<>();
        for(Character c:source.toCharArray())
        {
            set.add(c);
        }
        for(Character c: target.toCharArray())
        {
            if(!set.contains(c)) return -1;
        }
        int i = 0; int j = target.length();
        int count = 0;
        while(i<j)
        {
            for(int k =0;k <source.length() && i < j;k++)
            {
                if(source.charAt(k)==target.charAt(i)) i++;
            }
            count++;
        }
        return  count;
    }
}