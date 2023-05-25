class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        # dic = collections.defaultdict(int)
        # l = len(tops)
        # count = []
        # for i in tops:
        #     dic[i]+= 1
        # for j in bottoms:
        #     dic[j] += 1
        # # print(dic)
        # for k, v in dic.items():
        #     if v < l:
        #         continue
        #     else:
        #         # print("here", k)
        #         i = 0
        #         ctop = 0
        #         cbot = 0
        #         while i < l:
        #             if tops[i] == k and bottoms[i]==k:
        #                 i+=1
        #             elif tops[i] == k:
        #                 # print("top")
        #                 i+=1
        #                 cbot+=1
        #             elif bottoms[i] == k:
        #                 # print("bot")
        #                 i+=1
        #                 ctop += 1
        #             else:
        #                 break
        #         if i == (l):
        #             count.append(min(ctop, cbot))
        #             # print(count)
        # if not count:
        #     return -1
        # return min(count)
        
        # FANKIZ APPROACH
        # arr = [0] * 5
        
        # x = tops[0]
        # y = bottoms[0]
        
        # for i in range(len(tops)):
        #     if tops[i] != x and bottoms[i] != x and tops[i] != y and bottoms[i] != y:
        #         return -1
        #     if tops[i] == x:
        #         arr[0]+=1
        #     if bottoms[i] == x:
        #         arr[1] += 1
                
        #     if tops[i] == y:
        #         arr[2]+=1
        #     if bottoms[i] == y:
        #         arr[3] += 1
            
        #     if tops[i] == bottoms[i]:
        #         arr[4] += 1
        
        # if (arr[0] + arr[1] - arr[4]) == len(tops):
        #     return (min(arr[0], arr[1]) - arr[4])
        
        # if (arr[2] + arr[3] - arr[4]) == len(tops):
        #     return (min(arr[2], arr[3]) - arr[4])
        # return -1

        # Optimal Solution
        # Time O(n)
        # Space O(1)
        def check(target):
            trot = 0
            brot = 0
            for i in range(len(tops)):
                if tops[i] == target and bottoms[i] == target:
                    continue
                if tops[i] == target: brot += 1
                elif bottoms[i] == target: trot += 1
                else: return -1
            return min(trot, brot)
        ans = check(tops[0])
        if ans == -1:
            return check(bottoms[0])
        return ans
