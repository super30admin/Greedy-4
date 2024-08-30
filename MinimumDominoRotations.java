import java.util.HashMap;
import java.util.HashSet;

public class MinimumDominoRotations {

    //Time complexity: O(N) where N is the number of dominos/ tops.length
    //Space complexity: O(1) no auxiliary space used
    public int minDominoRotations(int[] tops, int[] bottoms) {
        if(tops.length != bottoms.length ){
            return -1;
        }

        int topTarget = tops[0];
        int bottomTarget = bottoms[0];

        //check if topTarget gives an ans
        int topTargetRotations = getMinRotationsForTarget(tops, bottoms, topTarget);
        if(topTargetRotations != -1 || topTarget == bottomTarget ){
            return topTargetRotations;
        }

        int bottomTargetRotations = getMinRotationsForTarget(tops, bottoms, bottomTarget);
        return bottomTargetRotations;

    }

    private int getMinRotationsForTarget(int[] tops, int[] bottoms, int target){

        int topRotations = 0;
        int bottomRotations = 0;

        for(int i = 0; i < tops.length; i++){
            if(tops[i] != target && bottoms[i] != target){
                return -1;
            }
            if(tops[i] != target){
                topRotations++;
            }
            if(bottoms[i] != target){
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations);
    }



    //Time complexity: O(N) where N is the number of dominos/ tops.length
    //Space complexity: O(1) we are using the
    // HashMap but we will always have keys in the range [1, 6]
     public int minDominoRotationsUsingHashMap(int[] tops, int[] bottoms) {
         if(tops.length != bottoms.length ){
             return -1;
         }
         HashMap<Integer, Integer> freqMap = new HashMap<>();
         int numberOfElements = tops.length;;

         int maxFrequency = createFrequencyMap(tops, bottoms, freqMap);
         int target = 0;

         for(int currentValue : freqMap.keySet() ){
             if(freqMap.get(currentValue) == maxFrequency){
                 target = currentValue;
             }
         }

         int topRotations = 0;
         int bottomRotations = 0;
         for(int i = 0; i < numberOfElements; i++){
             if(tops[i] != target && bottoms[i] != target ){
                 return -1;
             }
             if(tops[i] != target){
                 topRotations++;
             }
             if(bottoms[i] != target){
                 bottomRotations++;
             }
         }
         return Math.min(topRotations, bottomRotations);
     }

     private int createFrequencyMap(int[] tops, int[] bottoms,  HashMap<Integer, Integer> freqMap){
         int maxFreq = 0;
         for(int i = 0; i < tops.length; i++){
             int topValue = tops[i];
             int bottomValue = bottoms[i];

             freqMap.put(topValue, freqMap.getOrDefault(topValue, 0) + 1);
             freqMap.put(bottomValue, freqMap.getOrDefault(bottomValue, 0) + 1);

             maxFreq = Math.max(maxFreq, Math.max( freqMap.get(topValue), freqMap.get(bottomValue) ) );
         }

         return maxFreq;
     }


    //Time complexity: O(N) where N is the number of dominos/ tops.length
    //Space complexity: O(N) where N is the number of dominos/tops.length
     public int minDominoRotationsBruteForce(int[] tops, int[] bottoms) {
         if(tops.length != bottoms.length ){
             return -1;
         }

         HashMap<Integer, HashSet<Integer>> valueToTopIndexMap = new HashMap<>();
         HashMap<Integer, HashSet<Integer>> valueToBottomIndexMap = new HashMap<>();
         int numberOfDominos = tops.length;

         createValueToIndexMap(tops, valueToTopIndexMap);
         createValueToIndexMap(bottoms, valueToBottomIndexMap);

         int minRotations = Integer.MAX_VALUE;

         for(int topValue  : valueToTopIndexMap.keySet() ){
             if(! valueToBottomIndexMap.containsKey(topValue)){
                 continue;
             }

             //the indices need to complements of each other
             int currMinRotations = Integer.MAX_VALUE;
             for(int i = 0; i < numberOfDominos; i++){
                 HashSet<Integer> topSet = valueToTopIndexMap.get(topValue);
                 HashSet<Integer> bottomSet = valueToBottomIndexMap.get(topValue);

                 if(! topSet.contains(i) && ! bottomSet.contains(i)){
                     break;
                 }
                 if(i == numberOfDominos - 1){
                     currMinRotations = numberOfDominos -  Math.max(topSet.size(), bottomSet.size());
                 }
             }
             minRotations = Math.min(minRotations, currMinRotations);
         }
         return minRotations == Integer.MAX_VALUE ? -1 : minRotations;

     }

     private void createValueToIndexMap(int[] nums,  HashMap<Integer, HashSet<Integer>> map){

         for(int i = 0 ; i < nums.length; i++){
             int value = nums[i];
             if(! map.containsKey( value )){
                 map.put(value, new HashSet<>());
             }
             map.get(value).add(i);
         }
     }
}
