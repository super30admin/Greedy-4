/*
TC - O(N) - performed linear scans only
SC - O(1) - did not use extra space
Issues Faced - I was overcomplicating and simulating the problem, essentially we can just count swaps and take a minimum. Need to revisit.

Solved on LeetCode - Yes


*/

class Solution {
    public:
    
    
        int helper(int target, vector<int> &tops, vector<int> &bottoms) {
            
            int n = tops.size();
    
            int topCount = 0;
            int bottomCount = 0;
    
            for (int i = 0 ; i < n; i++) {
    
                if (tops[i] != target && bottoms[i] != target) {
                    return -1;
                }
    
                if (tops[i] == target) {
                    topCount += 1;
                }
    
                if (bottoms[i] == target) {
                    bottomCount += 1;
                }
            }
    
            int topSwaps = n - topCount;
            int bottomSwaps = n - bottomCount;
    
            return min(topSwaps, bottomSwaps);
    
        }
        int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
            //core logic
    
            /*
            
            minimum rotations wanted - so candidate is whichever side has a greater count of the max freq element
    
    
            */
    
    
            int n = tops.size();
    
            int topElement = tops[0];
    
            int bottomElement = bottoms[0];
    
            int ans1 = helper(topElement, tops, bottoms);
            int ans2 = helper(bottomElement, tops, bottoms);
    
            if (ans1 == -1 && ans2 == -1) {
                return -1;
            }
            
            if (ans1 == -1) return ans2;
            if (ans2 == -1) return ans1;
    
            return min(ans1, ans2);
        }
    };
