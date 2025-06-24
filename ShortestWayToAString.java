class Solution {
    public int shortestWay(String source, String target) {
        if(source.equals(target)) {
            return 1;
        }
        if(source == null || source.length() == 0) {
            return -1;
        }
        // HashSet<Character> set = new HashSet<>();
        HashMap<Character, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < source.length(); i++) {
            char c = source.charAt(i);
            if(!map.containsKey(c)) {
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        int sp = 0; //pointer in the source string
        int tp = 0; //pointer in the target string
        int count = 1; 
        while(tp < target.length()) {
            char c = target.charAt(tp);
            if(!map.containsKey(c)) {
                return -1;
            }
            List<Integer> li = map.get(c);
            int k = Collections.binarySearch(li, sp);
            if(k < 0) {
                k = -k - 1;
            }
            if(k == li.size()) {
                count++;
                sp = 0;
            }
            else {
                sp = li.get(k);
                sp++;
                tp++;                
            }
        }
        return count;
    }
}