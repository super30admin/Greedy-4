//time complexity-O(n^2)
//Space complexity-O(1)
//Ran on leetcode-Yes
//Solution with comments-
class Solution {
    public int shortestWay(String source, String target) {
        int ans=0;
        
        int t= target.length();
        int s= source.length();
        
        int TP=0;
        int SP=0;
        while(TP<t){
            SP=0;
            int prev=TP;
            while(TP<t && SP<s){
                if(source.charAt(SP)==target.charAt(TP)){
                    TP++;
                }
                SP++;
            }
            if(prev==TP)
                return -1;
            
            ans++;
        }
        
        return ans;
    }
}