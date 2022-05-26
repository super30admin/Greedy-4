//Time Complexity O(N)
//Space Complexity O(1)
//Leetcode tested
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] a, int[] b) {
        if(a == null || a.length == 0) return 0;
        int result = check(a,b,a[0]);
        if(result!=-1) return result;
        return check(a,b,b[0]);
    }
    public int check(int[] a,int[] b,int target){
        int aRot=0;
        int bRot=0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] != target && b[i]!= target) return -1;
            else if(a[i]!=target) aRot++;
            else if(b[i]!=target) bRot++;
        }
        return Math.min(aRot,bRot);
    }
}