// Time Complexity : O(len(S)*len(T))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int shortestWay(String source, String target) {
        int ptrS = 0;
        int ptrT = 0;
        int result = 0;
        boolean[] isPresent = new boolean[26];
        for(int i = 0 ; i < source.length() ; i++){
            char c = source.charAt(i);
            isPresent[c-'a'] = true;
        }
        while(ptrT < target.length()){
            //System.out.println(ptrS+" "+ptrT);
            if(!isPresent[target.charAt(ptrT)-'a']) return -1;
            if(source.charAt(ptrS) == target.charAt(ptrT)) 
                ptrS++;
                ptrT++;
            }else{
                ptrS++;
            }
            if(ptrS == source.length() || ptrT == target.length()){
                ptrS = 0;
                result++;
            }
        }
        return result;
    }
