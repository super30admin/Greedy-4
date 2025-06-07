'''

The understanding is that you need to have an element repeated atleast certain number of times which is equal to the length of the tops/bottom, that's when the problem even qualify for the next steps of the problem.


Once you find that element, then you can make sure that whether your bottom and top matches and return the min (top and bottom), that when you lead to the answer.


Time complexity: O(n)
Space complexity : O(1)

Although we are using hash_map, it is gonna remain constant, as the values which goes in hash_map wont be more than 26.


'''


class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:

        hash_map = defaultdict(int)

        top, bottom =0,0

        min_qualification_length = len(bottoms)

        for i in tops:
            hash_map[i]+=1

        for i in bottoms:
            hash_map[i]+=1


        if max(hash_map.values())<min_qualification_length:
            return -1

        for i in hash_map:

            if hash_map[i]>=min_qualification_length:
                pursue_value = i


        i=0

        while(i<min_qualification_length):

            if(tops[i]!=pursue_value and bottoms[i]!=pursue_value):
                return -1

            elif(tops[i]==pursue_value and bottoms[i]!=pursue_value):
                bottom+=1

            elif(bottoms[i]== pursue_value and tops[i]!=pursue_value):
                top+=1


            i+=1
        return min(top, bottom)



