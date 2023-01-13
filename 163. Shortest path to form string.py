class Solution:
    def shortestWay(self, source, target):
        sl = len(source)
        tl = len(target)
        i = 0
        pos = 0
        counter = 1
        hashMap = dict()

        for j in range(sl):
            char = source[j]
            hashMap[char] = j

        while i < tl:

            if target[i] not in hashMap:
                print(-1)
                return -1

            if target[i] == source[pos]:
                i += 1
                pos += 1
            else:
                pos += 1

            if pos == sl and i < tl:
                pos = 0
                counter += 1
        print(counter)
        return counter


source = "abc"
target = "abcbc"
source1 = "abc"
target1 = "acdbc"
source2 = "xyz"
target2 = "xzyxz"
source3 = "aaaaa"
target3 = "aaaaaaaaaaaaa"

if __name__ == "__main__":
    obj = Solution()
    obj.shortestWay(source,target)
    obj.shortestWay(source1, target1)
    obj.shortestWay(source2, target2)
    obj.shortestWay(source3, target3)

# Two Pointers
# Time Complexity :O(m * n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

