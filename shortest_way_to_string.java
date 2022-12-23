//TC-O(mn)
//SC-O(1)
    public int shortestWay(String source, String target) {
        int t=0; //terget index
        int res=0; //final answer
        
        while(t<target.length()){
            int prevT = t;
            //greedily matching as many as chars possible from source to target
            for(int s=0;s<source.length();s++){
                if(t<target.length() && source.charAt(s) == target.charAt(t))
                    t++;
            }
            //if we are not able to find for match for the char from target
            //in source we won't be able to form target
            if(t == prevT)
                return -1;
            res++;
        }
        return res;
    }