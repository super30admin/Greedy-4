// Problem: Shortest Way to Form a String
// Time Complexity: O(n * m), where n is the length of source and m is the length of target.
// Space Complexity: O(n), where n is the length of source, for storing characters in a set.

// Approach: 
// 1. Create a set of characters from the source string.
// 2. Check if all characters in the target string are present in the source string.
// 3. Use two pointers to traverse the source and target strings.
// 4. Count how many times we need to traverse the source string to form the target string.


#include <string>
#include <unordered_set>
using namespace std;
class Solution {
public:
    int shortestWay(string source, string target) {
        unordered_set<char> set(source.begin(), source.end());
        for(char i : target){
            if(set.find(i) == set.end()){
                return -1;
            }
        }

        int i = 0;
        int count = 0; 
        while(i < target.size()) {
            int j = 0; 
            int prev_i = i;

            while(j < source.size() && i < target.size()){
                if(source[j] == target[i]){
                    i++;
                }
                j++;
            }
            if(i == prev_i){
                return -1;
            }
            count++;
        }
        return count;
    }
};