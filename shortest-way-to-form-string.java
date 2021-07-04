/*

https://leetcode.com/problems/shortest-way-to-form-string/


Time Complexity: 0(M*N)
Space Complexity: 0(1)

Here we can have subsequences which need not be continuous
Algorithm:
- We have two pointers source pointer sp and target pointer tp and global variable result
- while tp<length of target
-  char index of sp and char index of tp are equal we increment both sp,tp
-  if they are not equal we increment sp
-  whenever sp goes out of bound increment result by 1

There might be some characters in target which not be present in source target.
if we don't find a character SP will make one entire pass and come back to the same point, which will tell the character is not present and return -1.

*/


class Solution {
    public int shortestWay(String source, String target) {
        
        int s = source.length();
        int t = target.length();
        
        int sp=0,tp=0;
        int result =0;
        
        
        while(tp<t){
            sp = 0;
            int curr = tp;
            
            while(sp<s){
                if(tp<t && source.charAt(sp)==target.charAt(tp)){
                    tp++;
                }
                sp++;
            }
            
            if(curr==tp){
                return -1;
            }
            
            result +=1;
        }
        
        return result;
        
    }
}