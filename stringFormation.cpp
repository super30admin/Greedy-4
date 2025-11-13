#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We build a map of all character positions in source to help us search faster.
For each character in target, you binary search (using a built-in method) to get the next valid position in source.
If we run out of source, we reset and count one subsequence used, repeating until target is formed.
*/
class Solution{
public:
    int shortestWay(string source, string target){
        unordered_map<char, vector<int>> map;
        
        for(int i = 0; i < source.length(); i++){
            map[source[i]].push_back(i);
        }

        int i = 0, j = 0;
        int count = 0;

        while(j < target.length()){
            char tChar = target[j];
            if(map.find(tChar) == map.end()) return -1;

            vector<int>& list = map[tChar];
            auto it = lower_bound(list.begin(), list.end(), i);
            int idx = it - list.begin();

            if(idx == list.size()){
                i = list[0];
                count++;
            }else i = list[idx];

            i++; j++;
            if(j == target.length()) return count + 1;

            if(i == source.length()){
                i = 0;
                count++;
            }
        }
        return -1;
    }
};
