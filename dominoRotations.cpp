#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
First,, we tru to make all dominos show the first top value by checking swaps needed
If that doesn't work, we try the first bottom value instead
We count how many swaps we needed on each side and return the minimum
*/
class Solution{
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms){
        int re = helper(tops, bottoms, tops[0]);
        if(re != -1) return re;

        return helper(tops, bottoms, bottoms[0]);
    }

    int helper(vector<int>& tops, vector<int>& bottoms, int target){
        int topR = 0, botR = 0;

        for(int i =0; i < tops.size(); i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            if(tops[i] == target && bottoms[i] == target) continue;
            if(tops[i] != target) topR++;
            if(bottoms[i] != target) botR++;
        }

        return min(topR, botR);
    }
};
