/*
method1: count number of occurences of elements in both A and B
To achieve rotation, we need to have atelast 1 number with occurence > n/2
Record the max freq element.
take arot and brot variables to keep count of rotations
if both numbers do not match max number then return -1
else if number in A matches,then arot++
else if number in B matches, then brot++

return minimum of arot and brot

TC: O(n)
SC: O(n)

method 2 - greedy approach
TC: O(n)
SC:O(1)

Here we greedily check if the firsl element of array A can be a target and give result;
if yes, return result
else check for array B

in getMinRotations function, we check if neither of elements  of the pair i.e A[i] and B[i] is equal to target then return -1. 

Else conitnue to check which is equal and increase the rotations count respectively. 


*/
class Solution {
    
    
    //method 2
    public int minDominoRotations(int[] A, int[] B){
        if(A.length == 0 || B.length == 0 || A == null || B == null){
            return 0;
        }
        
        int result = getMinRotations(A,B, A[0]);
        if(result != -1){
            return result;
        }
        return getMinRotations(A, B, B[0]);
    }
    
    private int getMinRotations(int[] A, int[] B, int target){
        int aRot = 0;
        int bRot = 0;
        
        for(int i = 0;i < A.length;i++){
            if(A[i] != target && B[i] != target){
                return -1;
            }
            
            else if(A[i] != target){
                aRot++;
            }
            else if(B[i] != target){
                bRot++;
            }
        }
        
        return Math.min(aRot, bRot);
    }
//     public int minDominoRotations(int[] A, int[] B) {
        
//         if(A.length == 0 || A == null)return 0;
//         if(B.length == 0 || B == null)return 0;
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         int max = 0;
        
//         for(int i = 0; i < A.length;i++){
//             int count = 0;
//             if(map.containsKey(A[i])){
//                 count = map.get(A[i]);
//                 count += 1;
//                 map.put(A[i],count);
//                 if(count >= A.length){
//                     max = A[i];
//                     break;
//                 }
                    
//             }else{
//                 map.put(A[i],1);
//             }
//             if(map.containsKey(B[i])){
//                 count = map.get(B[i]);
//                 count += 1;
//                 map.put(B[i],count);
//                 if(count >= B.length){
//                     max = B[i];
//                     break;
//                 }
                    
//             }else{
//                 map.put(B[i],1);
//             }
            
//         }
//         int aRot = 0;
//         int bRot = 0;
//         for(int i = 0; i < A.length;i++){
//             if(A[i] != max && B[i] != max){
//                 return -1;
//             }
//             else if(B[i] != max){
//                 bRot++;
//             }else if(A[i] != max){
//                 aRot++;
//             }
//         }
//         return Math.min(aRot, bRot);
//     }
}