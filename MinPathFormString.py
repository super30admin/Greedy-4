# Time complexity: O(m*n), space: O(1)
from collections import defaultdict

# The intuition here is to first create a set out of source string, then check if any of
# target char is not in source then return -1.
# Otherwise, check each char one at a time and then whenever the source array crosses
# the length, then bring it back to 0 and increment the count.

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        n = len(source)
        m = len(target)
        sourceSet = set(source)
        for c in target:
            if c not in sourceSet:
                return -1
        sp = 0
        tp = 0
        count = 0
        while tp < len(target):
            if target[tp] == source[sp]:
                tp += 1
                sp += 1
            else:
                sp += 1
            if sp == n:
                sp = 0
                count += 1
        return count

    # Here we use a hashmap of the index of source as a list and char as the key. So that to check if that
    # char is present in the target string. If it is then we can directly jump to that source index
    # getting it from hashmap and a do a binary search, that saves us time. And gives us time complexity of O(mlogn).
    # Space will be O(n) for hashmap
    def shortestWayOptimal(self, source: str, target: str) -> int:
        n = len(source)
        m = len(target)
        indexMap = defaultdict(list)
        for i, c in enumerate(source):
            indexMap[c].append(i)

        sp = 0
        tp = 0
        count = 0

        while(tp < m):
            tChar = target[tp]
            if tChar not in indexMap: return -1
            li = indexMap[tChar]
            idx = self.binarySearch(li, sp)

            if idx == len(li):
                sp = li[0]
                count += 1
            else:
                sp = li[idx]
                sp += 1
                tp += 1
                if tp == len(target):
                    return count + 1
            if i == len(source):
                i = 0
                count += 1
        return -1

    def binarySearch(self, arr, target):
        low, high = 0, len(arr) - 1
        while (low <= high):
            mid = low + (high-low)//2
            if arr[mid] == target:
                return mid
            elif arr[mid] > target:
                high = mid-1
            else:
                low = mid+1
        return low
