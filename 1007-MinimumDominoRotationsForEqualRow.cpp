/* 
    Time Complexity                              :  O(N)
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
public:
    int shortestWay(string source, string target) {
        int tn=target.size(),sn=source.size();
        int t=0,s=0,pt=0,count=0;
        while(t<tn) {
            if(source[s] == target[t]){
                t++;
            }
            s++;
            
            if(s >= sn) {
                if(pt == t) return -1;
                pt = t;
                s = 0;
                count++;
            }
            
            if(t == tn) {
                if(s == 0) return count;
                else return count+1;
            }
        }
        
        return -1;
    }
};