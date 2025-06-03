// Problem: Minimum Domino Rotations For Equal Row
// Time Complexity: O(n), where n is the number of dominoes.
// Space Complexity: O(1), since we are using a constant amount of space for variables.

// Approach: 
// 1. Check if we can make all dominoes in the top row equal to the first element of the top row.
// 2. If not, check if we can make all dominoes in the bottom row equal to the first element of the bottom row.
// 3. If neither is possible, return -1.
// 4. Use a helper function to count the number of rotations needed for each case.
// 5. Return the minimum number of rotations needed.

#include <vector>
using namespace std;
class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int rot = check(tops[0], tops, bottoms, tops.size());
        if(rot != -1 || tops[0] == bottoms[0]){
            return rot;
        }
        return check(bottoms[0], tops, bottoms, tops.size());
    }
private: 
    int check(int x, vector<int>& a, vector<int>& b, int n) {
        int arot = 0; 
        int brot = 0; 
        for(int i = 0; i < n; i++) {
            if(a[i] != x && b[i] != x){
                return -1;
            }
            else if(a[i] != x){arot++;}
            else if(b[i] != x){brot++;}
        }
        return min(arot, brot);
    }
};