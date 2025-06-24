class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int target = -1;
        int le = tops.length;
        int re = check(tops, bottoms, tops[0]);
        if(re!=-1) return re;
        return check(tops, bottoms, bottoms[0]);

        
    }

    private int check(int[] tops, int[] bottoms, int target){
        int trot =0, brot = 0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!= target && bottoms[i]!=target) return -1;
            if(tops[i]!=target) trot++;
            if(bottoms[i]!=target) brot++;

        }

        return Math.min(trot, brot);
    }
}