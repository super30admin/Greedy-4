// TC - O(n X m)

// SC - O(1)

// LC - 1055

class Solution {
    public int shortestWay(String source, String target) {
		// Sanity check
        if(source == null || source.length() == 0 || target == null || target.length() == 0){
            return 0;
        }
		// t to track target position and ct to count number of partitions
        int t = 0;
        int ct = 0;
		// Iterate over target
        while(t < target.length()){
			// To avoid infinity loop
            int prev = t;
			// Iterate over source, if characters match, increment t
            for(char ch : source.toCharArray()){
                if(ch == target.charAt(t)){
                    t++;
                    if(t == target.length()){
                        return ct+1;
                    }
                }
            }
            if(prev == t){
                return -1;
            }
            ct++;
        }
        return ct;
    }
}