"""
Brute Force TP Approach -
TC - O(m * n) where m is length of source string and n is length of target string
SC - O(1) ==> constant number of characters in hset
"""


class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        if source == target: return 1

        # initialize pointers
        sp = 0
        tp = 0

        hset = set()
        count = 0

        for i in range(len(source)):
            hset.add(source[i])
        # print("hset: ", hset)

        while tp < len(target):
            count += 1

            while sp < len(source) and tp < len(target):
                if target[tp] not in hset:
                    return -1
                if source[sp] == target[tp]:
                    sp += 1
                    tp += 1
                else:
                    sp += 1
            # reset to 0 when target char not found
            sp = 0

        return count
