class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int num1= tops[0];
        int num2= bottoms[0];
        if(check(num1,tops,bottoms)>-1)
            return check(num1,tops,bottoms);
        if(check(num2,tops,bottoms)>-1)
            return check(num2,tops,bottoms);
        return -1;
    }
   private int check(int num, int[]tops, int [] bottoms)
   {   int tcount=0,bcount=0;
       for(int i =0;i<tops.length;i++)
       {
           if(tops[i]!=num && bottoms[i]!=num)
               return -1;
           if(tops[i]!=num)
               tcount++;
           if(bottoms[i]!=num)
               bcount++;
       }
    return Math.min(tcount, bcount);
       
   }
}