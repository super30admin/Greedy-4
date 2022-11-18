class Solution {
    //tc-o(n) sc-o(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int candidate = -1;
        for(int i=0;i<n;i++)
        {
            int t = tops[i];
            map.put(t,map.getOrDefault(t,0)+1);
            int cntT = map.get(t);
            if(cntT >= n)
            {
                candidate = t;
                break;
            }
            int b = bottoms[i];
            map.put(b,map.getOrDefault(b,0) +1);
            int cntB = map.get(b);
            if(cntB >= n)
            {
                candidate = b;
                break;
            }
        }
        if(candidate == -1) return -1;
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