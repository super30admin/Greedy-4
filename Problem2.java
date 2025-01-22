
class Problem2 {
    //TC: O(N)
    //TC: O(1)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        Map<Integer,Integer> freq = new HashMap<>();
        int target =-1;
        for(int i=0;i<tops.length;i++){
            freq.putIfAbsent(tops[i],0);
            freq.put(tops[i],freq.get(tops[i])+1);
            if(freq.get(tops[i]) == tops.length){
                target =  tops[i];
                break;
            }
        }

        for(int i=0;i<bottoms.length;i++){
            freq.putIfAbsent(bottoms[i],0);
            freq.put(bottoms[i],freq.get(bottoms[i])+1);
            if(freq.get(bottoms[i]) == bottoms.length){
                target = bottoms[i];
                break;
            }


        }
        int topCnt = 0, btmCnt = 0;
        for(int j=0;j<tops.length;j++){
            if(tops[j] != target && bottoms[j] !=target) return -1;
            if(tops[j] != target){
                topCnt++;
            }
            if(bottoms[j] != target){
                btmCnt++;
            }
        }

        return Math.min(btmCnt,topCnt);
    }
}