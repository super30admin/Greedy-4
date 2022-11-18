class Solution {
    //tc-o(n) sc-o(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int result = check(tops,bottoms,tops[0]);
        if(result != -1) return result;
        else return check(tops,bottoms, bottoms[0]);

    }
    private int check(int[] tops,int[] bottoms,int candidate)
    {
        int n = tops.length;
        int tRot = 0;
        int bRot = 0;
        for(int i=0;i<n;i++)
        {
        if(tops[i] != candidate && bottoms[i] != candidate) return -1;
        if(tops[i] != candidate) tRot++;
        if(bottoms[i] != candidate) bRot++;
        }
        return Math.min(tRot,bRot);

    }
}