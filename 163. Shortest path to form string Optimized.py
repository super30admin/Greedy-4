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
            if char not in hashMap:
                hashMap[char] = []
            hashMap.get(char).append(j)

        while i < tl:
            if target[i] not in hashMap:
                print(-1)
                return -1
            #finding the corresponding index of our current char of target with the closest binary search in list of indices of that char in hashMap
            li = hashMap.get(target[i])

            k = self.binarySearch(li, pos)
            if k < 0:
                k = -k - 1
            if k == len(li):
                counter += 1
                pos = li[0]
            else:
                pos = li[k] + 1
                i += 1
            # pos += 1

        return counter

    def binarySearch(self, nums, x):
        low = 0
        high = len(nums)

        while low < high:
            mid = low + (high - low) // 2

            if nums[mid] == x:
                return mid
            elif nums[mid] > x:
                high = mid - 1
            else:
                low = mid + 1
        return -1



source = "abc"
target = "abcbc"
source1 = "abc"
target1 = "acdbc"
source2 = "xyz"
target2 = "xzyxz"
source3 = "abcdad"
target3 = "aaaaaaaaaaaaa"

if __name__ == "__main__":
    obj = Solution()
    obj.shortestWay(source,target)
    obj.shortestWay(source1, target1)
    obj.shortestWay(source2, target2)
    obj.shortestWay(source3, target3)

# Two Pointers
# Time Complexity :O(mlogn)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

