//Link: https://leetcode.com/problems/shortest-way-to-form-string/submissions/
//Time: O(mXn) where m is S.length and n is t.length
//Space: O(1)
//Ran on leetcode and no issues

class Solution {
    public int shortestWay(String source, String target) {
        int result=0;
        int sLength=source.length(), tLength=target.length();
        int sp=0, tp=0; //source and target pointers
        while(tp<tLength){
            int curr=tp; //current pointer, we use it to test if target could move or not - important
            while(sp<sLength && tp<tLength){
                if(source.charAt(sp)==target.charAt(tp)){
                    sp++; tp++;
                }
                else{
                    sp++;
                }
            }
            if(curr==tp) return -1;
            sp=0; //reset
            result++;
        }
        return result;
    }
}
