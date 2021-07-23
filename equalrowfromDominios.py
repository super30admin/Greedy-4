# Space :- O(n)

# Time :- O(n)
class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        if tops is None or bottoms is None: return -1
        maxfrequency, maxelement = 0, 0
        freq_map = collections.defaultdict(int)
        # find ing the max occurnace of element

        for index in range(len(tops)):
            freq_map[tops[index]] += 1

            ctop = freq_map[tops[index]]
            if ctop > maxfrequency:
                maxfrequency = ctop
                maxelement = tops[index]

            freq_map[bottoms[index]] += 1
            cbottom = freq_map[bottoms[index]]
            if cbottom > maxfrequency:
                maxfrequency = cbottom
                maxelement = bottoms[index]

        # calculate the min count

        print(maxelement)

        bmin, tmin = 0, 0

        for index in range(len(tops)):

            if tops[index] != maxelement:
                bmin += 1
            elif bottoms[index] != maxelement:
                tmin += 1

        return min(bmin, tmin)








