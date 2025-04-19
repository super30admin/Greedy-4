// TC: O(N)
// SC: O(1)

public class LC1007 {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops==null || bottoms==null) return 0;
        if(tops.length!=bottoms.length) return 0;
        int n = tops.length;
        int ans = Integer.MAX_VALUE;
        int pos[] = new int[]{tops[0], bottoms[0]};
        for(int i: pos){
            int top = 0, bottom = 0;
            boolean flag = true;
            for(int j=0;j<n;j++){
                if(tops[j]==i && bottoms[j]==i) continue;
                else if(bottoms[j]==i) top++;
                else if(tops[j]==i) bottom++;
                else {
                    flag = false;
                    break;
                }
            }
            if(flag) ans = Math.min(Math.min(top, bottom), ans);
        }
        return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}
