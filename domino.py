# Time Complexity: O(n)
# Space Complexity: O(1)

def minDominoRotations(tops, bottoms):
    def check(x):
        rotations_a = rotations_b = 0
        for a, b in zip(tops, bottoms):
            if a != x and b != x:
                return -1
            elif a != x:
                rotations_a += 1
            elif b != x:
                rotations_b += 1
        return min(rotations_a, rotations_b)

    rotations = check(tops[0])
    if rotations != -1 or tops[0] == bottoms[0]:
        return rotations
    else:
        return check(bottoms[0])
