class Solution:
    def shortestWay(self, source: str, target: str) -> int:
        ##time - O(nm)
        ##space-O(1)
        ######################### sol1-same impl #################
        i = 0
        j = temp = ro = 0
        #         while i<len(target) and j<len(source):
        #             if target[i]==source[j]:
        #                 recur=0
        #                 i+=1
        #                 j+=1
        #             else:
        #                 j+=1
        #             # print(ro)
        #             if j==len(source) and recur>0:
        #                 return -1
        #             elif i==len(target) and j!=len(source):
        #                 return ro+1
        #             elif j==len(source):
        #                 j=0
        #                 recur+=1
        #                 ro+=1

        #         return ro

        ######################### sol2-same impl #################
        count = 0
        while j < len(target):
            count += 1
            i = 0
            curr = j
            while i < len(source) and j < len(target):
                if target[j] == source[i]:
                    j += 1
                i += 1
            if curr == j:
                return -1
        return count
