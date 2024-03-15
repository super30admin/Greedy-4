/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(m*n)
    m - length of source
    n - length of target
* 
* Space Complexity: O(1)
* 
*/

public class ShortestPathString {
    public int shortestWay(String source, String target) {
        int m = source.length();

        int n = target.length();

        int i = 0, j = 0;

        int subsequenceCount = 0;

        while (j < n) {
            boolean jFoundOnce = false;

            i = 0;

            while (i < m && j < n) {
                if (target.charAt(j) == source.charAt(i)) {
                    i++;
                    j++;
                    jFoundOnce = true;
                } else {
                    i++;
                }
            }

            if (!jFoundOnce) {
                return -1;
            }

            subsequenceCount++;
        }

        return subsequenceCount;
    }
}