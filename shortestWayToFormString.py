"""
Time Complexity: O(M * N) where M is the length of source and N is the length of target
Space Complexity: O(1)
Compiled on Leetcode?: Yes
"""


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        tPointer = 0
        sPointer = 0
        result = 0
        while tPointer < len(target):
            sPointer = 0
            curr = tPointer
            while tPointer < len(target) and sPointer < len(source):
                if source[sPointer] == target[tPointer]:
                    tPointer += 1
                    sPointer += 1
                else:
                    sPointer += 1
            if curr == tPointer:
                return -1
            result += 1
        return result
