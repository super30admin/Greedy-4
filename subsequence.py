#As taught in class using 2 pointers to solve this problem
#Time Complexity: O(n)
#Space Compleity: O(n)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sl = len(source)
        tl = len(target)
        tp = 0
        sp = 0
        count = 0
        while tp < tl:
            count = count + 1
            sp = 0
            curr = tp     
            while (sp < sl):
                if (source[sp] == source[tp]):
                    tp += 1
                sp += 1
            if (curr == tp):
                return -1
        return count
                