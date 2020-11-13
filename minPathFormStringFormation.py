# // Time Complexity : O(S*T)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach
# Two pointers: keep two pointers, each one at the beginning of target and source. While target pointer is valid(not out of nounds): start from source ptr at 0. 
# then if you find the element in S and T move S and T ptr ahead. If you S ptr goes out of bounds, increment result counter. If you move S ptr ahead and don't move T ptr ahead=> element in T wasn't found in S, hence return -1. 

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        s = len(source)
        t = len(target)
        
        TP, SP= 0, 0
        output = 0
        
        while TP<t:
            SP=0
            prev = TP
            while TP<t and SP<s:
                if source[SP] == target[TP]:
                    TP+=1
                SP+=1
        
            if prev == TP:
                return -1

            output +=1
        
        return output
                
            
                    
        