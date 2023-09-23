#Time Complexity :O(s*tlog(s))
#Space Complexity :O(s)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        map={}
        count=1
        j=0
        i=0
        k=0
        for s in range(len(source)):
            sChar=source[s]
            if sChar not in map.keys():
                map[sChar]=[]
            map.get(sChar).append(s)

        while j<len(target):
            tChar=target[j]
            if tChar not in map.keys():
                return -1
            li=map.get(tChar)
            k=bisect.bisect_left(li,i)
            if k==len(li):
                i=li[0]
                count+=1
            else:
                i=li[k]
            i+=1
            j+=1

            if j==len(target):
                return count
        return -1


