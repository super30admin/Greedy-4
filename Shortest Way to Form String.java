//Time Complexity-O(n^2)
//Space-O(1)
class Solution {
    public int shortestWay(String source, String target) {
        int sp=0;
        int tp=0;
        int res=0;
        while(tp<target.length())
        {
            int prev=tp;
            sp=0;
            while(sp<source.length()&&tp<target.length())
            {
                if(source.charAt(sp)==target.charAt(tp))
                {
                    tp++;
                }
                sp++;
            }
            if(prev!=tp)
            {
                res+=1;
            }
            else{
                return -1;
            }
        }
       return res; 
    }
}