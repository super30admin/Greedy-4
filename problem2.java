import java.util.HashMap;

// Leetcode Problem 1007: Minimum Domino Rotations For Equal Row
// https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/
// Time Complexity: O(n)
// Space Complexity: O(1)

public class problem2 {
    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        HashMap<Integer, Integer> count = new HashMap<>();
        int n = tops.length;
        int target = 0;

        for(int i=0;i<n;i++)
        {
            count.put(tops[i], count.getOrDefault(tops[i], 0) + 1);
            if(bottoms.length== count.get(tops[i]))
            {
                break;
            }
            count.put(bottoms[i], count.getOrDefault(bottoms[i], 0) + 1);
            if(tops.length== count.get(bottoms[i]))
            {
                break;
            }
        }
        int topR=0, bottomR=0;
        for(int i=0;i<n;i++)
        {
            if (tops[i]!=target && bottoms[i]!=target) {
                return -1;
            }
            if (tops[i]!=target) {
                topR++;
            }
            if (bottoms[i]!=target) {
                bottomR++;
            }
        }

        return Math.min(topR, bottomR);
    }
}
