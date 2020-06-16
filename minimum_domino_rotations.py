"""
// Time Complexity : O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
- Compute the count of elements of both the arrays
- Get the maximum frequency element from the compilation of all eelements in both 
the arrays
- Get the primary array(arraving maximum frequency element)
- Iterate through primary array
    - if current value == max ele then continue
    - else if secondary_array[i] != max_ ele
        break # valid rotations not possible
    - else
        count+=1
- return count or -1 (if not valid)
"""

from collections import Counter
class Solution:
    def minDominoRotations(self, A: List[int], B: List[int]) -> int:
        c1 = Counter(A)
        c2 = Counter(B)
        
        counts = {}
        for i in A:
            counts[i] = counts.get(i,0)+1
        
        for i in B:
            counts[i] = counts.get(i,0)+1
        
        print(counts)
        
        #c1 = sorted(c1,key = lambda x:x[1])
        #c2 = sorted(c2,key = lambda x:x[1])
        
        max_ele_freq = float("-inf")
        max_ele = -1
        for k,v in counts.items():
            #max_ele = max(max_ele,v)
            if max_ele_freq < v:
                max_ele_freq = v
                max_ele = k
        
        if c1.get(max_ele,-1) > c2.get(max_ele,-1):
            primary_arr = A
            secondary_arr = B
        else:
            primary_arr = B
            secondary_arr = A
        
        count = 0
        flag = True
        for i,v in enumerate(primary_arr):
            if v == max_ele:
                continue
            elif secondary_arr[i]!=max_ele:
                flag = False
                break
            else:
                count+=1
        
        if not flag:
            return -1
        
        return count