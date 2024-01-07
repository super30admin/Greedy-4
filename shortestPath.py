#TC: O(n)
#SC: O(n)

class solution:
    def shorestWay(self, source: str, target: str) -> int:
        if( source == None or len(source) == 0 or len(target) == 0):
            return -1
        m = len(source)
        n = len(target)
        tp = 0 #target pointer
        sp = 0 #source pointer
        counter = 0
        set = {}
        for i in range(m):
            set.add(source[i])
        while(tp < n):
            c = target[tp]
            if(c not in set):
                return -1
            if(target[tp] == source[sp]):
                tp += 1
                sp += 1
            else:
                sp += 1
            if(sp == m or tp == n):
                sp = 0
                count += 1
        return count
