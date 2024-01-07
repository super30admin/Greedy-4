#TC: O(logn)
#SC: O(n)
import bisect
class solution:
    def shorestWay(self, source: str, target: str) -> int:
        if( source == None or len(source) == 0 or len(target) == 0):
            return -1
        m = len(source)
        n = len(target)
        tp = 0 #target pointer
        sp = 0 #source pointer
        count = 1
        set = {}
        for i in range(m):
            c = source[i]
            for i in range(source):
                c = source[i]
                if(c not in set.keys()):
                    set.add(c)
                set[c]= i
        while(tp < n):
            c = target[tp]
            if(c not in set):
                return -1
            li = set.get(c)
            k = bisect.left(li,sp)
            if(k == len(li)):
                sp = 0
                count += 1
            else:
                sp = li.get(k)
                tp+=1
                sp+=1
        return count

            


                


            
