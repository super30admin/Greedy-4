#All TC on leetcode passed 

class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        #Here we take candidate as 1st entry of tops and bottoms array. We check if tops or bottoms can be made tops[0]. If yes we return the min of making tops or bottoms to tops[0]. If no then we check if tops and bottoms can be made to bootoms[0]. If yes we return the min of making tops or bottoms to bottoms[0] else -1. Here any pair of array can be made the candidate. But 0 is taken so that we dont get IndexOutOfBoundException.  
        #Time complexity - O(n)
        #Space comeplxity - O(1)
        n = len(tops)
        r1 = self.check(tops, bottoms, n, tops[0])
        if r1!=-1:
            return r1
        r2 = self.check(tops, bottoms, n, bottoms[0])
        return r2

    #function to check number of swaps required to make array equal to candidate
    def check(self, tops, bottoms, n, candidate):
        tr = 0
        br = 0

        for i in range(n):
            if tops[i]!=candidate and bottoms[i]!=candidate:
                return -1
            if tops[i]!=candidate:
                tr+=1
            if bottoms[i]!=candidate:
                br+=1
        return min(tr, br)




#----------------------------------------OR------------------------------------

        #Here we form frequency map of nums in tops and bottoms. Any num which has fq >= length of array is the most suitable candidate to change the tops or bottoms array. With this chosen candidate we check number of swaps needed to make tops array to candidate or bottoms array to candidate. Min of these is returned
        #Time complexity - O(2n) - where n is length of tops/bottoms array. One n for forming frequency map and another n for iterating through tops and bottoms to find min rotations.
        #Space complexity - O(1) - fq map has only fixed nums from 1 to 6
        map = {}
        n = len(tops)
        candidate = -1

        #create frequency map and find the most repeated number which forms the candidate
        for i in range(n):
            if tops[i] not in map:
                map[tops[i]] = 1
            else:
                map[tops[i]] += 1
            
            if map[tops[i]]>=n:
                candidate = tops[i]
                break

            if bottoms[i] not in map:
                map[bottoms[i]] = 1
            else:
                map[bottoms[i]] += 1
            
            if map[bottoms[i]]>=n:
                candidate = bottoms[i]
                break
        
        #check if tops can be made all same with candidate or bottoms can be made all same with candidate. Return min of those.
        tr = 0
        br = 0
        for i in range(n):
            if bottoms[i]!=candidate and tops[i]!=candidate:
                return -1
            if tops[i]!=candidate:
                tr+=1
            if bottoms[i]!=candidate:
                br+=1
            
        return min(tr, br)




        
