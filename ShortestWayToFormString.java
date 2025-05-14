import java.util.HashSet;

/**
 * Time Complexity: O(m*n)
 * Space Complexity: O(1)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 2 pointers
 */

public class ShortestWayToFormString {
    // --------- 2 pointers ---------------
    public int shortestWay(String source, String target) {
        if (source.equals(target)) {
            return 1;
        }

        int sIndex = 0;
        int tIndex = 0;

        char[] sourceArray = source.toCharArray();
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for (char c: sourceArray) {
            set.add(c);
        }

        while (tIndex < target.length()) {
            if (!set.contains(target.charAt(tIndex))) {
                return -1;
            }
            
            if (source.charAt(sIndex) == target.charAt(tIndex)) {
                tIndex++;
                sIndex++;
            } else {
                sIndex++;
            }

            if (sIndex == source.length() && tIndex < target.length()) {
                count++;
                sIndex = 0;
            }  
        }

        return count + 1;
    }

    public static void main(String[] args) {
        // Your code here
    }
}