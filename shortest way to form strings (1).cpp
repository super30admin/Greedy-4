//Time Complexity-O(m*n)--->'m' is length of source string and 'n' is length of target string
//Space Complexity-O(1)
//Did the code execute on Leetcode? Yes

class Solution {
public:
    int shortestWay(string source, string target) {
        int low=0;
        int high=0;
        int count=0;
        while(high<target.length())
        {
            low=0;
            int a=high;
            while(low<source.length())
            {
                if(target[high]==source[low])
                {
                    high++;
                    low++;
                }
                else
                {
                    low++;
                }
            }
            if(high==a)
            {
                return -1;
            }
            count++;
        }
        return count;
    }
};