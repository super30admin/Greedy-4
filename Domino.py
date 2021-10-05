#Space:o(n)
#time:O(n)
from collections import defaultdict
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        if not tops or not bottoms:
            return -1
        dict_val=defaultdict(int)
        
        key = -1
        
        for bottom in bottoms:
            dict_val[bottom]+=1
            if dict_val[bottom]>=len(bottoms):
                key=bottom
        for top in tops:
            dict_val[top]+=1
            if dict_val[top]>=len(tops):
                key=top
        if key ==-1:
            return -1
        
        for i in range(len(bottoms)):
            if bottoms[i]!=key and tops[i]!=key:
                return -1
        key_count_bottom=0
        key_count_top = 0
        
        for i in range(len(bottoms)):
            if bottoms[i]==key and tops[i]!=key:
                key_count_bottom+=1
            if tops[i]==key and bottoms[i]!=key :
                key_count_top+=1
        return min(key_count_bottom,key_count_top)
            