//time - O(n^2), space - O(1)
class Solution {
    public int shortestWay(String source, String target) {
        if(source==null || target==null || source.length()==0 || target.length()==0) return 0;
        int result = 1;
        int i=0, pos=0;
        Map<Character, Integer> map = new HashMap<>();

        for(int j=0; j<source.length(); j++){
            char ch = source.charAt(j);
            map.put(ch, j);
        }

        while(i < target.length()){
            char src = source.charAt(pos);
            char trgt = target.charAt(i);

            if(!map.containsKey(trgt)){
                return -1;
            }

            if(src==trgt){
                pos++;
                i++;
            }
            else{
                pos++;
            }
            if(i < target.length() && pos==source.length()){
                result++;
                pos = 0;
            }
        }

        return result;
    }
}
