# 1055. Shortest Way to Form String
# https://leetcode.com/problems/shortest-way-to-form-string/

# Logic: We make a set for the source. We then iterate over 
# the target, at every instant we iterate over the source and 
# if it matches the target, we we increment the target pointer. 
# After the source reaches the end but target is not reached 
# the end, we do the same all over again. At the end we return 
# count. If at any case the element in the target is not in the 
# set, we return -1.

# Time Complexity: O(s*t)
# Space Complexity: O(s)

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sourceSet = set()
        
        for i in source:
            sourceSet.add(i)
        
        src, tgt = 0, 0
        count = 0
        
        while tgt < len(target):
            if target[tgt] not in sourceSet:
                return -1
            
            while src < len(source) and tgt < len(target):           
                if source[src] == target[tgt]:
                    tgt += 1
                src += 1

            count += 1
            src = 0
        return count