# Time: O(n)
# Space: O(1) # Because the length of dictionary is only 6 and the pos_targets array can only have 2 elements at max.
class Solution(object):
    def minDominoRotations(self, tops, bottoms):
        """
        :type tops: List[int]
        :type bottoms: List[int]
        :rtype: int
        """
        dic = {}
        pos_targets = []
        for i in range(1, 7):
            dic[i] = 0
        for i in range(len(tops)):
            if tops[i] != bottoms[i]:
                dic[tops[i]] += 1
                dic[bottoms[i]] += 1
            else:
                dic[tops[i]] += 1
            if dic[tops[i]] == len(tops):
                pos_targets.append(tops[i])
            if dic[bottoms[i]] == len(tops):
                pos_targets.append(bottoms[i])
                
        if len(pos_targets) == 0:
            return -1
        else:
            mn = 1000000000007
            for i in pos_targets:
                cnt_t = 0
                cnt_b = 0
                for j in range(len(tops)):
                    if tops[j] != i:
                        cnt_t += 1
                    if bottoms[j] != i:
                        cnt_b += 1
                mn = min(mn, min(cnt_t, cnt_b))
            return mn
                    
                
        
