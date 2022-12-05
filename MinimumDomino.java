//Time - O(n)
//Space - O(1)
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length!=bottoms.length) return -1;
        HashMap<Integer,Integer> countMap = new HashMap<>();
        int maxEle = tops[0];;
        for(int i=0; i< tops.length; i++){
            int t = tops[i];
            countMap.put(t, countMap.getOrDefault(t,0) + 1);
            if(countMap.get(t) > countMap.get(maxEle)){
                maxEle = t;
            }
            int b = bottoms[i];
            countMap.put(b, countMap.getOrDefault(b,0)+1);
             if(countMap.get(b) > countMap.get(maxEle)){
                maxEle = b;
            }
        }
        int tRot=0;
        int bRot=0;
        for(int i=0; i<tops.length; i++){
            if(tops[i] !=maxEle && bottoms[i]!= maxEle) return -1;
            if(tops[i]!=maxEle) tRot++;
            if(bottoms[i]!=maxEle) bRot++;
        }
        return Math.min(tRot,bRot);
    }
}
