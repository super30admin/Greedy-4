import java.util.*;
public class MinDominoRot {
    //TC=O(n)
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length;
        int candidate = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int t = tops[i];
            map.put(t,map.getOrDefault(t,0)+1);
            int cntT = map.get(t);
            if(cntT>=n){
                candidate = t;
                break;
            }
            int b = bottoms[i];
            map.put(b,map.getOrDefault(b,0)+1);
            int cntB = map.get(b);
            if(cntB>=n){
                candidate = b;
                break;
            }
        }
        if(candidate == -1)return -1;
        int tRot=0;
        int bRot = 0;
        for(int j=0;j<n;j++){
            if(tops[j]!=candidate && bottoms[j]!=candidate)return -1;
            if(tops[j]!=candidate)tRot++;
            if(bottoms[j]!=candidate)bRot++;
        }
        return Math.min(bRot,tRot);
    }
}
