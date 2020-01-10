#
# Initial thought of solution.
#
# class Solution:
#     global al
#     def minPath(self,source, target):
#         self.al = []
#         self.subSequence(source, "")
#         # print(self.al)
#         count = 0
#         for x in self.al:
#             # print(x)
#             if x in target and len(target) > 0:
#                 print(target)
#                 target = target.replace(x,'')
#                 count += 1
#         if len(target) != 0:
#             count = -1
#         return count
#
#
#
#     def subSequence(self,string, ans):
#
#         if len(string) == 0:
#             self.al.append(ans)
#             return
#
#
#         self.subSequence(string[1:],ans+string[0])
#         self.subSequence(string[1:],ans)
#

'''
Not tested on leetcode.
Time - O(M*N)
space - O(1)
'''
class Solution:
    def shortestWay(self, source, target):
        # initializing lengths, pointers and final return result.
        s = len(source)
        t = len(target)

        SP = 0
        TP = 0

        result = 0
        # iterate over target until TP reached end of string.
        while TP < t:
            SP = 0 # reset SP each time it goes out of bounds.
            curr = TP # initialize curr to TP, this is to check for if some char doesn't exist in source string.
            # iterate over source until SP reached end of string.
            while SP < s:
                 # case 1: source char is equal to target char then increment both pointers.
                if TP < t and source[SP] == target[TP]:
                    TP += 1
                # Case 2: else increment only source pointer, as target is a subsequence of source.
                SP += 1
            # after one iteration over source if the TP didn't change then that char is not in source, exit with -1
            if curr == TP:
                return -1
            # else increment result each time SP goes out of bound.
            result += 1
        return result

sol = Solution()
print(sol.shortestWay("xyz","xzyxz"))


