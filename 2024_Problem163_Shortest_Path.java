//1055. Sortest Way to form a String - https://leetcode.com/problems/shortest-way-to-form-string/description/

//2-pointer
//Time Complexity: O(m*n) ~ sizes of source and target strings
//Space Complexity: O(m) ~ set
class Solution {
    public int shortestWay(String source, String target) {
        int sp = 0, tp = 0;
        int count = 0;
        HashSet<Character> set = new HashSet<>();
        for(char c : source.toCharArray()){
            set.add(c);
        }

        while(tp < target.length()){
            char sChar = source.charAt(sp);
            char tChar = target.charAt(tp);

            if(!set.contains(tChar)) return -1;

            if(sChar == tChar){
                sp++; tp++;
                if(tp == target.length()) return count+1;
            } else {
                sp++;
            }

            if(sp == source.length()){
                sp=0;
                count++;
            }
        }
        return -1;
    }
}

//using Binary Search
//Time Complexity: O(n * log(k)) ~ 'k' is avg occurences of character
//Space Complexity: O(m) ~ source characters
class Solution {
    public int shortestWay(String source, String target) {
        int sp = 0, tp = 0;
        int count = 0;
        HashMap<Character, List<Integer>> map = new HashMap<>();

        for(int i=0; i<source.length(); i++){
            char c = source.charAt(i);
            map.putIfAbsent(c, new ArrayList<>());
            map.get(c).add(i);
        }

        while(tp < target.length()){
            char sChar = source.charAt(sp);
            char tChar = target.charAt(tp);

            if(!map.containsKey(tChar)) return -1;
            List<Integer> list = map.get(tChar);
            int idx = binarySearch(list, sp);
            if(idx == list.size()){
                count++;
                sp=0; //put pointer back to 0th idx
            } else {
                sp = list.get(idx);
                sp++; tp++;
                if(tp == target.length()) return count+1;
            }

            if(sp == source.length()){
                sp=0;
                count++;
            }
        }
        return -1;
    }

    private int binarySearch(List<Integer> list, int target){
        int n = list.size();
        int low = 0, high = n-1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(list.get(mid) == target) return mid;
            else if(list.get(mid) > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}