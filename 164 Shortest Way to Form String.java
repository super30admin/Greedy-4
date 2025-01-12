// Time Complexity : O(n+m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    //aesha
    public int shortestWay(String source, String target) {
        int i =0, j =0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();

        for(char c: source.toCharArray())
        {
            set.add(c);
        }

        while(j < target.length())
        {
            char schar = source.charAt(i);
            char tchar = target.charAt(j);
            if(!set.contains(tchar)) return -1;
            if(schar == tchar)
            {
                i++; j++;
                if(j == target.length()) return count+1;
            }
            else
            {
                i++;
            }
            if(i== source.length())
            {
                i=0;
                count++;
            }
        }
        return -1;
    }
    
}