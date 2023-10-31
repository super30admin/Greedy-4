//TC = O(n)
//SC =  O(1)

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = tops.length;
        int candidate = -1;
        for(int i=0; i<n; i++){
            int t = tops[i];
            map.put(t,map.getOrDefault(t,0)+1);
            int cnt1 = map.get(t);
            if(cnt1 >= n){
                candidate = t;
                break;
            }
            int b = bottoms[i];
            map.put(b,map.getOrDefault(b,0)+1);
            int cnt2 = map.get(b);
            if(cnt2 >= n){
                candidate = b;
                break;
            }
        }
        if(candidate == -1) return -1;
        int to = 0; int bt = 0;
        for(int i = 0 ;  i< n; i++){
            if(tops[i] != candidate && bottoms[i] != candidate) return -1;
            if(tops[i] != candidate) to++;
            if(bottoms[i] != candidate) bt++;
        }
        return Math.min(to,bt);
    }
}