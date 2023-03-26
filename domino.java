class Solution {
    public int minDominoRotations(int[] tops, int[] bottom) {
       int rot=check(tops[0],tops,bottom,tops.length);
       if(rot!=-1 ||tops[0]==bottom[0]) return rot;
       else return check(bottom[0],tops,bottom,tops.length);
    }
    public int check(int x, int[]a, int[] b,int n){
        int arot = 0;
        int brot = 0;
        for(int i=0;i<n;i++){
            if(a[i] != x && b[i]!=x) return -1;
            else if(a[i]!=x) arot++;
            else if(b[i]!=x) brot++;
        }
        return Math.min(arot,brot);
    }
}