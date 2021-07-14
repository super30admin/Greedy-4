class Solution:
    def shortestWay(self, source, target):
        t = 0
        result = 1
        t_len, s_len = len(target), len(source)

        while t < t_len:
            t_checkPoint = t
            for s in range(s_len):
                if source[s] == target[t]:
                    t += 1
                if t == len(target): # target fully built
                    return result
            if t == t_checkPoint: # did not build target further
                return -1
            result += 1

        return result
        