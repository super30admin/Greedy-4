/*
Approach1
Brute force : Form power set of source and check if the power set element is present in the target keep counting . Time complexity is O(2^n * length of target) as forming the powerset takes 2^n

Approach2:
Take source pointer to iterate on source and target pointer to iterate on target
if source pointer value is same as target pointer value increment both
but if not then reset source pointer to start and keping the target in the same position on incrementing from that position
Below is approach2
*/
class Solution {
    public int shortestWay(String source, String target) {
        int TP = 0; int SP = 0;
        int s = source.length();
        int t = target.length();
        int count = 0;
        while(TP < t){
           
            SP = 0;
            count++;  //count of the short way to get the target string
            int curr = TP;
            while(TP < t && SP < s){
           
                if(source.charAt(SP) == target.charAt(TP)){
                    SP++; TP++;
                }
                else{
                    SP++; //reset to 0 when no match and restart incrementing source pointer
                }
               
             }
           
            if(curr == TP ) return -1;
        }
        return count;
    }
}

/*
Time complexity : if m is length of source and n is length of target then O(mxn)
Space complexity : O(1)
*/