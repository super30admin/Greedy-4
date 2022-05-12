/*
Time Complexity: O(N), N is the length of Tops and Bottoms array
Space Complexity: O(1)
Run on leetcode: Yes
Any difficulties: no

Approach:
1. I would be assuming the initial element of the tops and bottoms array as the target which I would like to have
inorder to convert all the array in the same face
2. Kind of simulation of the problem.
3. Attempted Once discussed in the class
 */
public class MinimumDominoRotations {
    public static int minimumDominoRotations(int[] tops, int[] bottoms){
        int ans = minimumDominoRotations(tops, bottoms, tops[0]);

        if(ans == -1){
            ans = minimumDominoRotations(tops, bottoms, bottoms[0]);
        }

        return ans;
    }

    public static int minimumDominoRotations(int[] tops, int[] bottoms, int target){
        int topCount = 0;
        int bottomCount = 0;

        for(int i = 0; i<tops.length; i++){
            if(tops[i]!= target && bottoms[i]!= target){
                return -1;
            }

            if(tops[i]!= target){
                topCount++;
            }else if(bottoms[i]!= target){
                bottomCount++;
            }
        }
        return Math.min(topCount, bottomCount);
    }

    public static void main(String[] args){
        System.out.println("Minimum Domino Rotations: "+ minimumDominoRotations(new int[]{2,1,2,4,2,2}, new int[]{5,2,6,2,3,2}));
        System.out.println("Minimum Domino Rotations: "+ minimumDominoRotations(new int[]{3,5,1,2,3}, new int[]{3,6,3,3,4}));
    }
}
