

// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

public class MinPathFormation {
    public int minPathFormation(final String source, final String target) {
        final int size1 = source.length();
        final int size2 = target.length();

        var res = 0;
        int j = 0;
        while (j < size2) {
            res++;
            int i = 0;
            final int curr = j;
            while (i < size1 && j < size2) {
                if (source.charAt(i) == target.charAt(j)) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            //Check if current pointer is equal to target pointer,return -1
            if (j == curr) {
                return -1;
            }
        }
        return res;
    }

    public static void main(final String args[]) {
        final MinPathFormation mFormation = new MinPathFormation();
        final String source = "abc";
        final String target = "abcbc";
        System.out.println(mFormation.minPathFormation(source, target));
    }
}