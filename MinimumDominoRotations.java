public class MinimumDominoRotations {

//Time Complexity:O(n)
//Space Complexity:O(1)

// First, we try to make all dominos show the first top value by checking swaps needed.
// If that doesn't work, we try the first bottom value instead.
// We count how many swaps we need on each side and return the minimum.

    public int minDominoRotations(int[] tops, int[] bottoms)
    {
        int re = helper(tops,bottoms,tops[0]);

        if(re != -1) return re;

        return helper(tops,bottoms,bottoms[0]);
    }

    private int helper(int[] tops, int[] bottoms, int target)
    {
        int topR = 0, botR = 0;

        for(int i=0;i<tops.length;i++)
        {
            if(tops[i]!= target && bottoms[i] != target) return -1;

            if(tops[i] == target && bottoms[i] == target) continue;

            if(tops[i] != target) topR++;

            if(bottoms[i] != target) botR++;

        }
        return Math.min(topR, botR);    
    }
}
