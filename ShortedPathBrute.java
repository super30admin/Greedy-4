class Solution {
    //tc-o(t*s)
    //sc-o(s)
    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<sl;i++)
        {
            char c = source.charAt(i);
            set.add(c);
        }
        int sp=0;
        int tp = 0;
        int count = 1;
        while(tp<tl)
        {
            char sChar = source.charAt(sp);
            char tChar = target.charAt(tp);
            if(!set.contains(tChar)) return -1;
            if(sChar == tChar)
            {
                sp++;
                tp++;
                if(tp == tl)
                return count;

            }
            else
            {
                sp++;
            }
            if(sp == sl)
            {
                sp=0;
                count++;
            }

        }
        return count;
    }
}