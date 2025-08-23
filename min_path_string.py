# Time Complexity: O(n * m)
# Space Complexity: O(m)

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        source_set = set(source)
        for char in target:
            if char not in source_set:
                return -1

        res = 1
        i = 0
        j = 0
        matched = False
        while i < len(target):
            if source[j] == target[i]:
                i += 1
                matched = True
            j += 1
            if j == len(source):
                if not matched:
                    return -1
                j = 0
                res += 1
                matched = False
        return res
