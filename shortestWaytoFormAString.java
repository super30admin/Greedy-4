//TC: O(N)
//SC: O(1)
//Approach: Explained in comments

class Solution {
    public int shortestWay(String source, String target) {
        int sp=0,tp=0,result=0,curr=0;
        int T = target.length(), S = source.length();
        while(tp<T){
            sp=0;
            curr = tp;
            while(sp<S){
            //we can iterate through source any no. of times, and then we would reset sp back to the beginning of source
            if(tp<T&&source.charAt(sp)==target.charAt(tp)){
                tp++; //moving on to the next char in target once the match occurs
            }
            sp++; //we increment the SP pointer anyway
        }
            if(curr==tp) return -1; //this means there was no match
        result++;
        }
        return result;

    }
}:
