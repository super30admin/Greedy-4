'''
Time Complexity : O(S*T)
Space Complexity : O(1)
'''

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        sl = len(source)
        tl = len(target)
        cur = 0
        result = 0
        
        while(cur<tl):
            cl = 0
            result +=1
            tp = cur
            while(cl<sl and cur<tl):
                if target[cur] == source[cl]:
                    cur +=1
                cl +=1
            if tp == cur:
                return -1
        return result