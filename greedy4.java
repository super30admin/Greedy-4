//problem1
class Solution {
    public int shortestWay(String source, String target) {
       
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        int i = 0, j = 0;
        int count = 0;

        while(j < target.length()){
            char tChar = target.charAt(j);

            if(!map.containsKey(tChar)) return -1;
            
            List<Integer> list = map.get(tChar);
            int idx = Collections.binarySearch(list, i);
            if(idx < 0){
                idx = -idx - 1;
            }
            if(idx == list.size()){
                i = list.get(0);
                count++;
            }else{
                i = list.get(idx);
            }
             
            i++; j++;
            if(j == target.length()) {
                return count+1;
            }
        
            if(i == source.length()){
                i = 0;
                count++;
            }
        }
        return -1;
    }
}
//problem2
class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
      int re=helper(tops,bottoms,tops[0]);
      if(re!=-1) return re;
      return helper(tops,bottoms,bottoms[0]);
    }
    public int helper(int[] tops,int[] bottoms,int tar){
        int topr=0,botr=0;
        for(int i=0;i<tops.length;i++){
            if(tops[i]!=tar && bottoms[i]!=tar) return -1;
            if(tops[i]==tar && bottoms[i]==tar) continue;
            if(tops[i]!=tar) topr++;
            if(bottoms[i]!=tar) botr++;
        }
        return Math.min(topr,botr);
    }
}
