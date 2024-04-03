// Time Complexity : O(n*m) 

    // where n - length of source and m - length of target

// Space Complexity : O(1)

// Did this code successfully run on Leetcode : YES

// Appoarch: Two pointers - one pointer on source and one on target. Each iteration on source
// is the count of subsequence. 

// 1055. Shortest Way to Form String

class Solution {
    public int shortestWay(String source, String target) {
        int sp = 0;
        int tp = 0;
        int count = 0;
        while(tp < target.length()){
            sp = 0;
            boolean tFound = false;
            while(sp < source.length() && tp < target.length()){
                if(source.charAt(sp) == target.charAt(tp)){
                sp++;
                tp++;
                tFound = true;
            }
            else{
                sp++;
            }
        }
        if(!tFound){
            return -1;
        }
        count++;
        }
        return count;
    }
}