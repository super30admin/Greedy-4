# TC:O(m*n)
# SC:O(m) where m is the len(source) which will not be more than 26. hence o(1)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if source is None or len(source) == 0:
            return -1

        hashmap = {}
        for i in range(0, len(source)):
            hashmap[source[i]] = i

        print(hashmap)
        i = 0
        pos = 0
        result = 0

        while i < len(target):
            if target[i] not in hashmap:
                return -1

            if target[i] == source[pos]:
                i += 1

            pos += 1

            if pos == len(source):
                result += 1
                pos = 0
                i += 1

        return result


# approach 2:
# TC:O(n log(m))
# SC:O(m) where m is the len(source) which will not be more than 26. hence o(1)
from bisect import bisect_left


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if source is None or len(source) == 0:
            return -1

        hashmap = {}
        for i in range(0, len(source)):
            if source[i] not in hashmap:
                hashmap[source[i]] = []
            hashmap[source[i]].append(i)

        i = 0
        pos = 0
        result = 1
        print(hashmap)
        while i < len(target):
            print("WHILE", target[i])
            if target[i] not in hashmap:
                return -1

            _list = hashmap.get(target[i])
            print("Target", target[i], "List", _list)
            k = bisect_left(_list, pos)
            print("Binary Index", k)

            if k == len(_list):
                pos = 0
                result += 1

            else:
                pos = _list[k] + 1
                i += 1

            print("Pos:", pos, "Index", i, "Result", result)
            print(" ")

        return result

