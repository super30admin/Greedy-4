//Time Complexity-O(n)-->'n' is size of input vectors
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    
    int calculate(vector<int>& A, vector<int>& B,int x)
    {
        int count1=0;
        int count2=0;
        for(int i=0;i<A.size();i++)
        {
            if(A[i]!=x && B[i]!=x)
            {
                return -1;
            }
            else if(A[i]!=x)
            {
                count1++;
            }
            else if(B[i]!=x)
            {
                count2++;
            }
        }
        return min(count1,count2);
    }
    
    int minDominoRotations(vector<int>& A, vector<int>& B) {
        if(A.size()==0 && B.size()==0)
        {
            return 0;
        }
        int res=calculate(A,B,A[0]);
        if(res!=-1)
        {
            return res;
        }
        else
        {
            return calculate(A,B,B[0]);
        }
    }
};