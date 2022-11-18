class Solution {
    //tc-o(nlogk)
    //sc-o(s)
    public int shortestWay(String source, String target) {
        int sl = source.length();
        int tl = target.length();
        HashMap<Character,List<Integer>> map = new HashMap<>();
        for(int i=0;i<sl;i++)
        {
            char c = source.charAt(i);
            if(!map.containsKey(c))
            map.put(c,new ArrayList<>());
            map.get(c).add(i);
        }
        int tp=0;int sp=0;
        int count=1;
        while(tp<tl)
        {
            char c = target.charAt(tp);
            if(!map.containsKey(c)) return -1;
            //get the key match from source 
            List<Integer> li = map.get(c);
            int k = Collections.binarySearch(li,sp);
            if(k<0)
            {//exact index not available
            //sp=7,[0,1,6,9,17,19] k=-3-1 = -4
            //sp=13, k = -4-1 = -5
            k = -k-1;//-(-4)-1 = 3
            //[0,1,6,9,17,19] sp=20
            }
            if(k == li.size())
            {
                sp=li.get(0);
                count++;
            }
            
            else
            {//exact index found from list
                sp = li.get(k);
            }
            sp++;
            tp++;

        }
        return count;
    }
}