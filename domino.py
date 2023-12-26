# Time: O(n)
# Space: O(1)
# Did it run on Leetcode: yes

class Solution(object):
    def minDominoRotations(self, tops, bottoms):
        """
        :type tops: List[int]
        :type bottoms: List[int]
        :rtype: int
        """
        # # O(n), O(n)
        # hmap={i:0 for i in range(1,7)}
        # n=len(tops)
        # target=-1
        # for i in range(n):
        #     tp=tops[i]
        #     hmap[tp]+=1
        #     if(hmap[tp]>=n):
        #         target=tp
        #         break
        #     bt=bottoms[i]
        #     hmap[bt]+=1
        #     if(hmap[bt]>=n):
        #         target=bt
        #         break
        # # print(target)
        # # print(hmap)
        # if(target==-1):
        #     print("in here")
        #     return -1
        # arot=0
        # brot=0
        # for i in range(n):
        #     if(tops[i]!= target and bottoms[i]!=target):
        #         return -1
        #     if(tops[i]!=target):
        #         arot+=1
        #     if(bottoms[i]!=target):
        #         brot+=1
        
        # return min(arot,brot)

        # O(n), O(1)
        def check(tops,bottoms, target):
            arot=0
            brot=0
            n=len(tops)
            for i in range(n):
                if(tops[i]!= target and bottoms[i]!=target):
                    return -1
                if(tops[i]!=target):
                    arot+=1
                if(bottoms[i]!=target):
                    brot+=1
            
            return min(arot,brot)
        if(tops==None or bottoms == None):
            return -1
        result=check(tops,bottoms, tops[0])
        if(result != -1):
            return result
        return check(tops,bottoms, bottoms[0])
