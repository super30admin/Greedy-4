# Time Complexity: O(mlogn) m is the len of target and n is length of source
# Space Complexity: O(n)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        # from collections import defaultdict
        # import bisect

        map = defaultdict(list)
        for i, c in enumerate(source):
            map[c].append(i)

        i = 0
        j = 0
        count = 0

        while j < len(target):
            tChar = target[j]

            if tChar not in map:
                return -1

            lst = map[tChar]
            idx = bisect.bisect_left(lst, i)

            if idx == len(lst):
                i = lst[0]
                count += 1
            else:
                i = lst[idx]

            i += 1
            j += 1
            if j == len(target):
                return count + 1

            if i == len(source):
                i = 0
                count += 1

        return -1