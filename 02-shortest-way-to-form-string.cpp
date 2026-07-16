/*
TC - O(L1 + L2) - since we only perform a linear scan
SC - O(1) - no extra space other than constants
Issues Faced - was able to think of the solution myself, but had some trouble thinking of edge cases. Need to revisit.
Solved on LeetCode - Yes


*/

class Solution {
    public:
        /**
         * @param s: Source string
         * @param target: Target string
         * @return: Number of subsequences that can be spliced into target
         */
        int shortestWay(string &s, string &target) {
            // write your code here
            /*
            1. find all subsequences of the given string s
            2. then greedily match the target string out of that, taking the biggest match you can get out of that set of subsequences..
            
            */
    
            int l1 = s.size();
            int l2 = target.size();
            int i = 0;
    
            int res = 0;
    
            for ( ; i < l2 ; i++) {
                int origPos = i;
                bool matchFound = false;
                for (int j = 0 ; j < l1 ; j++) {
                    if (s[j] != target[i]) { //skip if no match
                        continue;
                    } else {
                        i += 1;
                        matchFound = true;
                    }
                }
                if (matchFound) {
                    res += 1;
                    i -= 1; //compensate for outer increment
                } else {
                    return -1;
                }
            }
    
                return res; //we get here only if the string was found
            
        }
    };
