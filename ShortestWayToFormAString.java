import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ShortestWayToFormAString {
    //O(s) + O(t * log s)
    public int shortestWayOptimal(String source, String target) {
        if(source == null || source.isEmpty()){
            return -1;
        }

        HashMap<Character, List<Integer>> sourceCharIndexMap = new HashMap<>();
        for(int i = 0; i < source.length(); i++){
            char currentChar = source.charAt(i);
            if( ! sourceCharIndexMap.containsKey(currentChar) ){
                sourceCharIndexMap.put(currentChar, new ArrayList<>());
            }
            sourceCharIndexMap.get(currentChar).add(i);
        }

        int targetPtr = 0;
        int sourcePtr = 0;

        int numberOfSubsequences = 0;

        while(targetPtr < target.length() ){
            char targetChar = target.charAt(targetPtr);
            if( ! sourceCharIndexMap.containsKey(targetChar) ){
                return -1;
            }
            List<Integer> charIndexList = sourceCharIndexMap.get(targetChar);

            int nextOccurrenceIdx = getNextOccurrenceOfChar(charIndexList, sourcePtr);
            int sourceIdx = charIndexList.get(nextOccurrenceIdx);

            if(sourceIdx < sourcePtr ){
                sourcePtr = 0;
                numberOfSubsequences++;
            }else{
                sourcePtr = sourceIdx;
                sourcePtr++;
                targetPtr++;
            }
        }
        if(sourcePtr != 0){
            numberOfSubsequences++; //or just initialize numberOfSubsequences to 1
        }
        return numberOfSubsequences;
    }

    private int getNextOccurrenceOfChar(List<Integer> charIndexList, int target){
        //return the Idx of the smallest number >= target
        int low = 0;
        int high = charIndexList.size() - 1;

        while(low < high){
            int mid = low + (high - low) / 2;
            if(charIndexList.get(mid) < target){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    //Time complexity: O(s * t)  where s is the length of the source string and t is the
    //length of the target string
    // Space complexity: O(1)
     public int shortestWay(String source, String target) {
         if(source == null || source.length() == 0){
             return -1;
         }

         HashSet<Character> sourceChars = new HashSet<>();
         for(int i = 0; i < source.length(); i++){
             sourceChars.add(source.charAt(i));
         }

         int sourcePtr = 0;
         int targetPtr = 0;
         int count = 0;

         while(targetPtr < target.length() ){
             char targetChar = target.charAt(targetPtr);
             if( ! sourceChars.contains(targetChar) ){
                 return -1;
             }

             if(source.charAt(sourcePtr) == targetChar ){
                 sourcePtr++;
                 targetPtr++;
             }else{
                 sourcePtr++;
             }

             if(sourcePtr == source.length()){
                 count++;
                 sourcePtr = 0;
             }
         }

         if(sourcePtr != 0){
             count++;
         }

         return  count;
     }

    //O(2 ^ s) * O(t) brute force solution, gives TLE
     public int shortestWayBruteForce(String source, String target) {

         //create all the subsequences possible from the source
         List<List<StringBuilder>> subsequences = new ArrayList<>();
         StringBuilder empty = new StringBuilder();
         List<StringBuilder> initial = new ArrayList<>();
         initial.add(empty);
         subsequences.add(initial);

         for(int i = 0; i < source.length(); i++){
             char currentChar = source.charAt(i);
             List<StringBuilder> newBlock = new ArrayList<>();

             for(int k = 0; k < subsequences.size(); k++){
                 List<StringBuilder> currentBlock = subsequences.get(k);
                 for(StringBuilder prefix : currentBlock){
                     StringBuilder newSequence = new StringBuilder(prefix);
                     newSequence.append(currentChar);
                     newBlock.add(newSequence);
                 }
             }
             subsequences.add(newBlock);
         }

         //create a HashSet of subsequences
         HashSet<String> sourceSet = new HashSet<>();
         for(List<StringBuilder> block : subsequences){
             for(StringBuilder sb : block ){
                 sourceSet.add(sb.toString());
             }
         }

         //iterate over the target
         int count = 0;
         int start = 0;
         int end = 0;

         while(start < target.length() && end < target.length() ){
             while(end < target.length() && sourceSet.contains(target.substring(start, end + 1) ) ){
                 end++;
             }
             count++;
             if(start == end){
                 return -1;
             }
             start = end;
         }
         return count;
     }
}
