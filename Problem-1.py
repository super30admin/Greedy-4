# Time Complexity : O(N * M)  # For each subsequence pass through source (N), we may scan the whole source (M)
# Space Complexity : O(1)     # Only pointers and counters are used
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

# Explanation:
# We greedily match characters of target using subsequences of source.
# Each pass scans the source and tries to match as many target characters as possible.
# If a target character cannot be matched in a full scan, forming the string is impossible.

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        i = 0
        count = 0
        
        while i < len(target):
            j = 0
            start = i
            
            while j < len(source) and i < len(target):
                if source[j] == target[i]:
                    i += 1
                j += 1
            
            if start == i:
                return -1
            
            count += 1
        
        return count