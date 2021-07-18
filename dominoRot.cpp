//Time: O(n) where n is the size of the vector;
//Space: O(1)
class Solution {
public:
    int minDominoRotations(vector<int>& tops, vector<int>& bottoms) {
        int result = findRotations(tops,bottoms,tops[0]);
        if(result != -1) return result;
        return findRotations(tops,bottoms,bottoms[0]);
    }
    int findRotations(vector<int>& tops, vector<int>& bottoms,int target){
        int topRot = 0,botRot = 0;
        for(int i = 0 ; i < tops.size();i++){
            if(tops[i] != target && bottoms[i] != target) return -1;
            else if(tops[i] != target) topRot++;
            else if(bottoms[i] != target) botRot++;
        }
        return min(topRot,botRot);
    }
};