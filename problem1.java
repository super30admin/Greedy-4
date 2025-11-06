import java.util.HashSet;

// Leetcode Problem 1055: Shortest Way to Form String
// https://leetcode.com/problems/shortest-way-to-form-string/
// Time Complexity: O(m + n)
// Space Complexity: O(1)

public class problem1 {
    public int shortestWay(String source, String target)
    {
        int i=0, j=0;
        HashSet<Character> set = new HashSet<>();
        for(char c: source.toCharArray())
        {
            set.add(c);
        }
        int count=0;
        while (j<target.length()) {
            if (!set.contains(target.charAt(j))) {
                return -1;
            }
            if (source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
                if(j==target.length())
                {
                    return count+1;
                    //
                }
            }
            i++;
            if (i==source.length()) {
                i=0;    
                count++;
            }
        }
        return -1;
    }
}
