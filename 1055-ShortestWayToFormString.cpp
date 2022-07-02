/* 
    Time Complexity                              :  O(2*N) ~= O(N) when we need to check for both the top and the bottom value
    Space Complexity                             :  O(1)
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  

class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        if(tops.size() == 0 or bottoms.size() == 0) return -1;
        int m=tops[0], n=bottoms[0],i=0;
        
        int topC = minRot(tops, bottoms, m);
        // if(topC == -1) return -1;
        
        int botC = minRot(tops,bottoms, n);
        // if(botC == -1) return -1;
    
        if(topC == -1 and botC == -1)
            return -1;
        else if(topC == -1)
            return botC;
        else if(botC == -1)
            return topC;
        else
            return min(topC, botC);
    }
    
    
    int minRot(vector<int>& tops, vector<int>& bottoms, int val) {
        
        int topR = 0, botR = 0;
        int sz = tops.size();
        for(int i=0;i<sz;i++) {
            if(tops[i] == val and bottoms[i] == val) {
                topR += 0;
                botR += 0;
            } else if(tops[i] == val) {
                topR += 0;
                botR += 1;
            } else if(bottoms[i] == val) {
                topR += 1;
                botR += 0;
            } else {
                return -1;
            }
        }
        
        return min(topR,botR);
        
    }
};