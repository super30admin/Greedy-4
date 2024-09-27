//Time - O(n)
//Space - O(1)
class Solution {
public:
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        int max = -1;
        
        for(int i = 1;i<=6;i++){
            int freq = 0;
            for(int j = 0;j<A.size();j++){
                if(A[j] == i){
                    freq++;
                }
                if(freq>=A.size()){
                    max = i;
                    break;
                }
                
                if(B[j] == i){
                    freq++;
                }
                if(freq>=B.size()){
                    max = i;
                    break;
                }
            }
        }

        if(max == -1) return max;
        int aRot = 0,bRot = 0;
        
        for(int i = 0;i<A.size();i++){
            if(A[i]!=max && B[i]!=max) return -1;
            
            if(A[i]==max && B[i]!=max){
                aRot++;
            }
            
            if(B[i]==max && A[i]!=max){
                bRot++;
            }
        }
        
        return min(aRot,bRot);

        
    }
};