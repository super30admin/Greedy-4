"""
// Time Complexity : O(N)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Given below
"""
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        """
        s- abc
        t- acdbc
        Idea is to check for matching subsequences from target with source untill all the characters in target are matched, thus requiring resetting the source pointer
        With every reset- increment the result
        For handling the edge case (invalid case)
        - Check if the target pointer is unchanged at the time of first reset in source array
        """
        src_ptr = 0
        target_ptr = 0
        current = None
        result = 0
        while target_ptr < len(target):
            result+=1
            current = target_ptr
            src_ptr = 0
            while src_ptr < len(source) and target_ptr < len(target):
                if source[src_ptr] == target[target_ptr]:
                    src_ptr+=1
                    target_ptr+=1
                else:
                    src_ptr+=1
            if current == target_ptr:
                return -1
        return result