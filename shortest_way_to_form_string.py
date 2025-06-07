'''
 Time Complexity: O(n*m) --> where n is the length of target and m is the length of source.
  Space Complexity: O(1) --> ALthough we are using a set, it is not counted in space complexity
    as it is not dependent on input size.
  Although there is a solution with hashable and binary search which can reduce the time complexity to O(n*log(m)),
  I just went with the subp optimal approach for the time being.
'''

class Solution:
    def shortestWay(self, source: str, target: str) -> int:

        source_len = len(source)

        target_len = len(target)

        hash_set = set(source)

        i, j, count = 0,0,0

        while(i<target_len):

            if target[i] not in hash_set :
                return -1

            if(j== source_len):
                j=0
                count+=1


            if (target[i]==source[j]):
                i+=1
                j+=1
            else:
                j+=1


        return count+1


