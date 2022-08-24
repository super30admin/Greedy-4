//****163.1055. Shortest Way to Form String****
//Time complexity:o(m*n);
//Space complexity:o(1);
class Solution {
    public int shortestWay(String source, String target) {
        int sl=source.length();
        int tl=target.length();
        if(sl==0 && tl==0) return 0;
        int count=0;
        
        int sp=0;
        int tp=0;
        while(tp<tl)
        {
            count++;
            int pos=tp;
            while(sp<sl && tp<tl)
            {
                if(source.charAt(sp)==target.charAt(tp))
                {
                    sp++;
                    tp++;
                }
                else
                {
                    sp++;
                }
                
            }
            if(pos==tp) return -1;
            sp=0;
            
        }
        
        
        return count;
        
    }
}
