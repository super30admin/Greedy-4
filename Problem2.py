#time complexity o(mn)
#space complexity o(n)
class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        source_set = set(source)
        
        # If any character in target is not in source, impossible
        for c in target:
            if c not in source_set:
                return -1

        sl, tl = len(source), len(target)
        sp, tp = 0, 0
        count = 1

        while tp < tl:
            if source[sp] == target[tp]:
                tp += 1
            sp += 1

            # If we reached the end of source and still haven't matched all target
            if sp == sl and tp < tl:
                count += 1
                sp = 0  # restart from beginning of source

        return count
