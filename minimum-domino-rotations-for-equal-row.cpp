// Time omplexity: O(N)
// Space Complexity: O(1) max size of map will be 6
class Solution {
public:
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        unordered_map<int, int> mp;
        int maxFreq = 0; // max frequent number
        int aRot = 0;
        int bRot = 0;
        // finding the max frequent number
        for(int i = 0; i < A.size(); i++) {
            mp[A[i]]++;
            mp[B[i]]++;
            if(mp[A[i]] >= A.size()) {
                maxFreq = A[i];
                break;
            }
            if(mp[B[i]] >= A.size()) {
                maxFreq = B[i];
                break;
            }
        }
        
        for(int i = 0; i < A.size(); i++) {
            if(A[i] != maxFreq && B[i] != maxFreq) return -1;
            
            if(B[i] != maxFreq)
                bRot++;
            else if(A[i] != maxFreq)
                aRot++;
        }
        return min(aRot, bRot);
    }
};

// Time omplexity: O(N)
// Space Complexity: O(1) max size of map will be 6
class Solution {
public:
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        int maxFreq = 0; // max frequent number
        int aRot = 0;
        int bRot = 0;
        // finding the max frequent number
        for(int j = 1; j < 7; j++) {
            int count = 0;
            for(int i = 0; i < A.size(); i++) {
                if(A[i] == j) count++;
                if(B[i] == j) count++;
                if(count >= A.size()){
                    maxFreq = j;
                    break;
                }
            }
        }
        
        for(int i = 0; i < A.size(); i++) {
            if(A[i] != maxFreq && B[i] != maxFreq) return -1;
            
            if(B[i] != maxFreq)
                bRot++;
            else if(A[i] != maxFreq)
                aRot++;
        }
        return min(aRot, bRot);
    }
};

// Time omplexity: O(N)
// Space Complexity: O(1) 
class Solution {
public:
    int fn(vector<int>& A, vector<int>& B, int target) {
        int aRot = 0; 
        int bRot = 0;
        for(int i = 0; i < A.size(); i++) {
            if(A[i] != target && B[i] != target) return -1;
            
            if(B[i] != target)
                bRot++;
            else if(A[i] != target)
                aRot++;
        }
        return min(aRot, bRot);
    }
    
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        if(A.size() == 0) return 0;
        int res = fn(A, B, A[0]);
        if(res != -1) return res;
        
        return fn(A, B, B[0]);
    }
};
