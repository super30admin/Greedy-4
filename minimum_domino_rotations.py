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

        """
        More optimized(cleaner version)
        Essentially, get the maximum frequency element which equals to length of the any of the array
        - Initial config - arotations, brotations
        Iterate through the length of any array
            - If the both A[i] and B[i] are not equal to max freq element - return -1
            - if A[i] is equal to max_freq -> increment B rotations
            else - increment A rotations
        - Return min(a rotations, b rotations)
        """
        def check_result(X):
            a_rotations,b_rotations = 0,0
            for i in range(len(A)):
                if A[i]!= X and B[i] != X:
                    return -1
                elif A[i] == X and B[i] != X:
                    b_rotations+=1
                elif A[i] != X and B[i] == X:
                    a_rotations+=1
            return min(a_rotations,b_rotations)
        
        
        # Version to copmute the maximum frequency element
        dice_count = [0]*7
        max_freq_ele = -1
        count = 0
        for i in range(len(A)):
            dice_count[A[i]]+=1
            dice_count[B[i]]+=1
            if dice_count[A[i]] >= len(A):
                max_freq_ele = A[i]
            elif dice_count[B[i]] == len(A):
                max_freq_ele = B[i]
        
        print(max_freq_ele)
        a_rotations,b_rotations = 0,0
        
        """
        Idea is that we need to check for only two elements and that two any two elements of the A and B, so might as well check first element from each array and then run the checks considering the element as reference element- rest of the logic remains the same. we avoided the overhead of computing the max frequency element by doing this
        """
        result_A = check_result(A[0])
        if result_A == -1:
            return check_result(B[0])
        return result_A