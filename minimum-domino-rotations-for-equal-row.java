// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : -


// Your code here along with comments explaining your approach

class Solution {
    public int check(int x,int a[] ,int b[] ,int n) {
        int arot=0;
        int brot=0;
        for(int i = 0; i < n; i++)
        {
            if(a[i] != x && b[i] != x)
                return -1;
            else
                if(a[i] != x)
                    arot++;
            else
                if(b[i] != x)
                    brot++;
        }
        return Math.min(arot, brot);
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rot= check(tops[0], tops, bottoms, tops.length);

        if(rot!=-1 || tops[0] == bottoms[0])
            return rot;
        else
            return check(bottoms[0], tops, bottoms, tops.length);
    }
}