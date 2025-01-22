class Problem1 {
    //TC : O(M*N)
    //SC : O(M)
    public int shortestWay(String source, String target) {

        int m = source.length();
        int n = target.length();
        int count = 0;

        int sIdx = 0;
        int tIdx = 0;
        Set<Character> charSet = new HashSet<>();
        for(char in : source.toCharArray()){
            charSet.add(in);
        }
        while(tIdx < n){
            char sChar = source.charAt(sIdx);//abc
            char tChar = target.charAt(tIdx);//abcbc
            if(!charSet.contains(tChar)) return -1;

            if(sChar == tChar){
                tIdx++;//2
                sIdx++;//2
                if(tIdx == n){
                    return count+1;
                }
            }else{
                sIdx++;//c
            }

            if(sIdx == m){
                sIdx = 0;
                count++; //1
            }

        }

        return count;
    }
}